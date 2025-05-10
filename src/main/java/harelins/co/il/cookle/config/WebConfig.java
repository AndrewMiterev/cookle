package harelins.co.il.cookle.config;

import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Configuration class for web-related settings.
 * Implements {@link WebMvcConfigurer} to customize Spring MVC configuration.
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    /**
     * Configures view controllers to forward requests to specific views.
     * Maps the "/project" URL to the "index.mustache" view.
     *
     * @param registry the {@link ViewControllerRegistry} to configure view controllers
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/project").setViewName("forward:/index.mustache");
    }


    /**
     * to allow CORS (if the servers are on different domains)
     *
     * @param registry see {@link CorsRegistry}
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*");
    }

    /**
     * @return Automatic detection of the current server URL via Spring Boot properties
     */
    @Bean
    public ServletWebServerFactory servletWebServerFactory() {
        return new TomcatServletWebServerFactory();
    }
}