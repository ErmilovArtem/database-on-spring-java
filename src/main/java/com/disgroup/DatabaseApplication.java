package com.disgroup;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.disgroup.database.controllers", "com.disgroup.database.entity", "com.disgroup.database.repository", "com.disgroup.database.service", "com.disgroup"})
@OpenAPIDefinition
public class DatabaseApplication {

    public static void main(String[] args) {
        SpringApplication.run(DatabaseApplication.class, args);
    }

}
