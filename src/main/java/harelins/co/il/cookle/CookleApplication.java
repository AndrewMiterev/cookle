package harelins.co.il.cookle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main application class for the Cookle application.
 * This class serves as the entry point for the Spring Boot application.
 */
@SpringBootApplication
@EnableScheduling
public class CookleApplication {

    /**
     * Main method to start the Cookle application.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(CookleApplication.class, args);
    }
}