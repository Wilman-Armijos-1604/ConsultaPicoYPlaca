package com.advlatam.consultapicoyplacabackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.advlatam", "com.advlatam.Controllers"})
public class ConsultapicoyplacaBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ConsultapicoyplacaBackendApplication.class, args);
    }
    
}
