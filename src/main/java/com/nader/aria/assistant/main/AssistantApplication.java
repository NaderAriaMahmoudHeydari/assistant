package com.nader.aria.assistant.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(value = "com.nader.aria.assistant.dao")
@ComponentScan(basePackages = {"com.nader.aria.assistant.business.service"
				,"com.nader.aria.assistant.config"
				,"com.nader.aria.assistant.web_services"})
@EntityScan(value = "com.nader.aria.assistant.entities")
public class AssistantApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssistantApplication.class, args);
	}
}
