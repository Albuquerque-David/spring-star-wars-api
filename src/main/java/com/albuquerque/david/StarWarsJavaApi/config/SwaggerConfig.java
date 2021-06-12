package com.albuquerque.david.StarWarsJavaApi.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Collections;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.albuquerque.david.StarWarsJavaApi"))
                .paths(PathSelectors.any())
                .build()
                .apiInfo(apiInfo());
    }

    private ApiInfo apiInfo() {
        return new ApiInfo(
                "Star Wars Spring Boot Java API",
                "Java API to manage Star Wars series planets.",
                "v1",
                "Terms Of Service Url",
                new Contact("David Rodrigues Albuquerque", "https://github.com/Albuquerque-David", "davidra_rj@hotmail.com"),
                "License of API", "License of URL", Collections.emptyList());
    }
}