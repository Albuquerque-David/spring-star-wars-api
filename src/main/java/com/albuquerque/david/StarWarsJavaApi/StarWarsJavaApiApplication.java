package com.albuquerque.david.StarWarsJavaApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.albuquerque.david.StarWarsJavaApi.repository")
@SpringBootApplication
public class StarWarsJavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsJavaApiApplication.class, args);
	}

}
