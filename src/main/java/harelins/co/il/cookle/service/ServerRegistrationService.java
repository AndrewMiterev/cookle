package harelins.co.il.cookle.service;

import harelins.co.il.cookle.dto.ServerRegistrationRequestDto;

public interface ServerRegistrationService {
    void registerNewServer(ServerRegistrationRequestDto request);

    void removeInactiveServers();
}
