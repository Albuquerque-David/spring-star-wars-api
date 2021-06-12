package com.albuquerque.david.StarWarsJavaApi;

import com.github.cloudyrock.spring.v5.EnableMongock;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@EnableMongoRepositories(basePackages = "com.albuquerque.david.StarWarsJavaApi")
@SpringBootApplication
@EnableMongock
public class StarWarsJavaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(StarWarsJavaApiApplication.class, args);
	}



}
