package harelins.co.il.cookle.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * Configuration class for RestTemplate bean.
 * Provides a singleton RestTemplate instance for HTTP requests.
 */
@Configuration
public class RestTemplateConfig {

    /**
     * Creates and configures a RestTemplate instance.
     *
     * @return configured RestTemplate bean
     */
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}