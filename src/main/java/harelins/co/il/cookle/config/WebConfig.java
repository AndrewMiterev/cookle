package harelins.co.il.cookle.config;

import org.springframework.context.annotation.Configuration;
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
}