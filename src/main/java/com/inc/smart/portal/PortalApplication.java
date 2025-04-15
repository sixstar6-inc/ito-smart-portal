package com.inc.smart.portal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PortalApplication {

	private final static Logger logger = LoggerFactory.getLogger(PortalApplication.class);

	@Value("${spring.ai.openai.api-key}")
	String apiKey;

	public static void main(String[] args) {
		SpringApplication.run(PortalApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> logger.info("open ai api-key : {}", apiKey);
	}

}
