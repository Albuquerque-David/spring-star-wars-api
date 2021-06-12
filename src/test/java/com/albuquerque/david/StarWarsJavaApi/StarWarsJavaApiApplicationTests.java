package com.albuquerque.david.StarWarsJavaApi;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.web.client.RestTemplate;

@EnableMongoRepositories(basePackages = "com.albuquerque.david.StarWarsJavaApi")
@SpringBootTest(classes = {RestTemplate.class})
class StarWarsJavaApiApplicationTests {

	@Test
	void contextLoads() {
	}

}
