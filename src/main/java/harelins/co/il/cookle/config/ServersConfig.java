package harelins.co.il.cookle.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "cookle")
public class ServersConfig {
    private List<String> additionalServers = new ArrayList<>();
    private String registrationAuthToken = "";
    private Boolean serverRegistrationEnabled = true;
    private List<String> registrationInitialServers = new ArrayList<>();
}