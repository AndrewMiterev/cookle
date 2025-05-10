package harelins.co.il.cookle.service.impl;

import harelins.co.il.cookle.config.ServersConfig;
import harelins.co.il.cookle.service.ServerListService;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Thread-safe implementation of ServerListService
 */
@Service
@RequiredArgsConstructor
public class ServerListServiceImpl implements ServerListService {
    private final ServersConfig serversConfig;

    private final List<String> servers = new CopyOnWriteArrayList<>();
    private final List<String> additionalServers = new CopyOnWriteArrayList<>();

    @Value("${server.self.url}")
    private String currentServer;

    @PostConstruct
    public void init() {
        // first step - always current server
        servers.add(currentServer);
        // adds start servers from config
        serversConfig.getAdditionalServers().forEach(this::addAdditionalServer);
    }

    @Override
    public List<String> getAllServers() {
        return Collections.unmodifiableList(servers);
    }

    @Override
    public List<String> getAdditionalServers() {
        return Collections.unmodifiableList(additionalServers);
    }

    @Override
    public String getCurrentServer() {
        return currentServer;
    }

    @Override
    public synchronized void addServer(String serverUrl) {
        if (!servers.contains(serverUrl) && !serverUrl.equals(currentServer)) {
            servers.add(serverUrl);
            additionalServers.add(serverUrl);
        }
    }

    @Override
    public synchronized void updateServersList(List<String> activeServers) {
        // always current server - first
        List<String> newServerList = new ArrayList<>();
        newServerList.add(currentServer);

        List<String> newAdditionalServers = new ArrayList<>();

        // adds only active servers
        activeServers.stream()
                .filter(url -> !url.equals(currentServer))
                .forEach(url -> {
                    newServerList.add(url);
                    newAdditionalServers.add(url);
                });

        // atomic list update (we under sync)
        servers.clear();
        servers.addAll(newServerList);

        additionalServers.clear();
        additionalServers.addAll(newAdditionalServers);
    }

    private void addAdditionalServer(String serverUrl) {
        if (!serverUrl.equals(currentServer) && !additionalServers.contains(serverUrl)) {
            servers.add(serverUrl);
            additionalServers.add(serverUrl);
        }
    }
}