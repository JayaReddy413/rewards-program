package com.rewards.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.rewards")
@EnableJpaRepositories(basePackages="com.rewards.repos")
@EntityScan(basePackages="com.rewards.model")
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}	
}