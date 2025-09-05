package com.sampleproject.sample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main-Klasse für die Sample Spring Boot Anwendung.
 */
@SpringBootApplication
public final class SampleApplication {
    /**
     * Privater Konstruktor.
     */
    private SampleApplication() {
        // Utility class
    }

    /**
     * Main-Methode.
     * @param args Programmargumente
     */
    public static void main(final String[] args) {
        SpringApplication.run(SampleApplication.class, args);
    }
}


