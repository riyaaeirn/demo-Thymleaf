package com.fedex.Orchestrator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.fedex.Orchestrator.*")
public class SpringbootWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootWebAppApplication.class, args);
	}

}
