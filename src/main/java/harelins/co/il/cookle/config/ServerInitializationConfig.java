package harelins.co.il.cookle.config;


import harelins.co.il.cookle.dto.ServerRegistrationRequestDto;
import harelins.co.il.cookle.service.ServerRegistrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * When the system starts, it initiates the process of registering this server on other servers.
 */
@Configuration
@RequiredArgsConstructor
@Slf4j
public class ServerInitializationConfig {

    private final ServersConfig serversConfig;

    @Bean
    public CommandLineRunner initServers(ServerRegistrationService registrationService) {
        return args -> {
            if (serversConfig.getServerRegistrationEnabled()) {
                List<String> registrationInitialServers = serversConfig.getRegistrationInitialServers();
                String authToken = serversConfig.getRegistrationAuthToken();

                registrationInitialServers.forEach(serverUrl -> {
                    try {
                        registrationService.registerNewServer(new ServerRegistrationRequestDto(serverUrl.trim(), authToken)
                        );
                    } catch (Exception e) {
                        log.error("Failed to register server: {}, Error: {}", serverUrl, e.getMessage());
                    }
                });
            }
        };
    }
}