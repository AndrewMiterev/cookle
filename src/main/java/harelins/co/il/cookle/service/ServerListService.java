package harelins.co.il.cookle.service;

import java.util.List;

/**
 * Service for managing and providing access to configured servers list
 */
public interface ServerListService {

    /**
     * Gets all configured servers including current server as first entry
     *
     * @return list of server URLs with current server first
     */
    List<String> getAllServers();

    /**
     * Gets only additional servers (excluding current server)
     *
     * @return list of additional server URLs
     */
    List<String> getAdditionalServers();

    /**
     * Gets current server URL
     *
     * @return current server base URL
     */
    String getCurrentServer();

    /**
     * Adds new server to list of additional servers
     *
     * @param serverUrl new server URL
     */
    void addServer(String serverUrl);

    /**
     * Sometime checks and deletes unavailable servers
     *
     * @param activeServers list of available servers
     */
    void updateServersList(List<String> activeServers);
}