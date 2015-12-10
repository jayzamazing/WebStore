package com.adrianjaylopez.webstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * This is the entry point for Spring Boot. 
 * @author Adrian J Lopez
 * @since <pre>6/13/15</pre>
 * @version 2.1
 */
@SpringBootApplication
public class WebStoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebStoreApplication.class, args);
    }
}
