package com.adrianjaylopez.webstore;

import com.adrianjaylopez.webstore.dao.User;
import com.adrianjaylopez.webstore.dao.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the entry point for Spring Boot. 
 * @author Adrian J Lopez
 * @since <pre>6/13/15</pre>
 * @version 1.0
 */
@ComponentScan("com.adrianjaylopez.webstore")
@SpringBootApplication
public class WebStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebStoreApplication.class, args);
    }

    private static final Logger log = LoggerFactory.getLogger(WebStoreApplication.class);
    @Bean
    public CommandLineRunner demo(UserRepository repo){
        log.info("blah");
        return (args) -> {
            repo.save(new User("superman", "kablah", "ROLE_ADMIN"));

            User user = repo.findByUsername("superman");
                log.info(user.toString());

        };
    }
}
