package harelins.co.il.cookle.service.impl;

import harelins.co.il.cookle.config.ServersConfig;
import harelins.co.il.cookle.dto.ServerRegistrationRequestDto;
import harelins.co.il.cookle.service.ServerListService;
import harelins.co.il.cookle.service.ServerRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class ServerRegistrationServiceImpl implements ServerRegistrationService {

    private final ServerListService serverListService;
    private final RestTemplate restTemplate;
    private final ServersConfig serversConfig;

    @Scheduled(fixedRate = 30000, initialDelay = 30000) // check all 30 sec
    @Override
    public void removeInactiveServers() {
        List<String> activeServers = serverListService.getAllServers().stream()
                .filter(this::isServerActive)
                .collect(Collectors.toList());

        serverListService.updateServersList(activeServers);
    }

    private boolean isServerActive(String serverUrl) {
        try {
            ResponseEntity<Void> response = restTemplate.getForEntity(
                    serverUrl + "/api/servers/heartbeat",
                    Void.class
            );
            return response.getStatusCode().is2xxSuccessful();
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public void registerNewServer(ServerRegistrationRequestDto request) {
        if (!serversConfig.getRegistrationAuthToken().equals(request.getAuthToken())) {
            throw new SecurityException("Invalid auth token");
        }

        serverListService.addServer(request.getServerUrl());

        // Оповещаем другие сервера о новом участнике
        notifyOtherServers(request.getServerUrl());
    }

    private void notifyOtherServers(String newServerUrl) {
        serverListService.getAdditionalServers().forEach(server -> {
            try {
                restTemplate.postForEntity(
                        server + "/api/servers/register",
                        new ServerRegistrationRequestDto(newServerUrl, serversConfig.getRegistrationAuthToken()),
                        Void.class
                );
            } catch (Exception e) {
                log.error("Error notifying server registration {}", newServerUrl);
            }
        });
    }
}