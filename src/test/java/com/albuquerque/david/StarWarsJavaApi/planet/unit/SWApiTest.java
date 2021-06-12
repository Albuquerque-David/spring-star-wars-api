package com.albuquerque.david.StarWarsJavaApi.planet.unit;

import com.albuquerque.david.StarWarsJavaApi.data.dto.PlanetDTO;
import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.google.gson.Gson;
import org.bson.json.JsonObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.data.domain.Example;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import springfox.documentation.spring.web.json.Json;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Unit tests for the PlanetRepository class.
 *
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = {RestTemplate.class})
public class SWApiTest {


    private Planet planet;

    @Autowired
    private RestTemplate restTemplate;

    private final String swapiUri = "https://swapi.dev/api/";

    @BeforeEach
    private void SetUp(){

        planet = new Planet("43","Cerea", "temperate", "verdant");

    }

    @AfterEach
    private void TearDown(){

    }

    @Test
    @DisplayName("Receives an id and search the PlanetDTO in the SWApi with the correspondent id.")
    public void findPlanetByIdTest(){
        PlanetDTO response;
        try{
            response = restTemplate.getForObject(swapiUri + "planets/" + planet.getId() + "/", PlanetDTO.class);
        }
        catch(HttpClientErrorException.NotFound ex){
            response = null;
        }

        if(response != null)
            assertEquals(response.getName(), planet.getName());
    };

}
