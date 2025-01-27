package com.example.springprac;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class SpringpracApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringpracApplication.class, args);
	}

}
