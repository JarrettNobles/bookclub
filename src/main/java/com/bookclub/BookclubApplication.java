package com.bookclub;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
 * Program Name: Book Club Application
 * File Name: BookclubApplication.java
 * Author: Jarrett Nobles
 * Description:
 *   This class serves as the main entry point for the
 *   Book Club Spring Boot application. It is responsible
 *   for bootstrapping and launching the application
 *   using the Spring framework.
 */

/**
 * The BookclubApplication class initializes and runs
 * the Spring Boot application.
 */
@SpringBootApplication
public class BookclubApplication {

    /**
     * The main method launches the Spring Boot application.
     *
     * @param args Command-line arguments passed to the application
     */
    public static void main(String[] args) {
        SpringApplication.run(BookclubApplication.class, args);
    }
}

