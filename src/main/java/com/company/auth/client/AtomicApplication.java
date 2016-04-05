package com.company.auth.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RestController;




@Configuration
@ComponentScan
@EnableAutoConfiguration
@EnableEurekaClient
@RestController
@SpringBootApplication
public class AtomicApplication extends SpringBootServletInitializer {
	
	
	
	@Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(AtomicApplication.class);
    }
	
	 public static void main(String[] args) {
	        SpringApplication.run(AtomicApplication.class, args);
    }

}
