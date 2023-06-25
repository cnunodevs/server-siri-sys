package com.senatic.siri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories
@SpringBootApplication
public class SiriApplication {

	public static void main(String[] args) {
		SpringApplication.run(SiriApplication.class, args);
	}

}
