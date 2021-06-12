package com.albuquerque.david.StarWarsJavaApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@EnableMongoRepositories(basePackages = "com.albuquerque.david.StarWarsJavaApi.repository")
@SpringBootTest
class StarWarsJavaApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
