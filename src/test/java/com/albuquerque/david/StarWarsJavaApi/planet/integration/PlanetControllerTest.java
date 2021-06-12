package com.albuquerque.david.StarWarsJavaApi.planet.integration;

import com.albuquerque.david.StarWarsJavaApi.controller.PlanetController;
import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.AutoConfigureDataMongo;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * Integration tests for the PlanetController class.
 *
 */
@ExtendWith(SpringExtension.class)
@ComponentScan("com.albuquerque.david.StarWarsJavaApi")
@WebMvcTest(controllers = PlanetController.class)
@AutoConfigureDataMongo
public class PlanetControllerTest {

    private final String endpoint = "/api/v1/planet";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PlanetRepository repository;

    @Autowired
    private ObjectMapper objectMapper;

    private Planet planet;
    private Planet planet2;
    private Planet planet3;
    private Planet planet4;
    private Planet missingDataPlanet;
    private Planet sameIdPlanet;
    private Planet nonExistingPlanet;

    @BeforeEach
    private void SetUp(){

        planet = new Planet("1","Planet 1", "Climate 1", "Terrain 1");
        planet2 = new Planet("2","Planet 2", "Climate 2", "Terrain 2");
        planet3 = new Planet("3","Planet 3", "Climate 3", "Terrain 3");
        planet4 = new Planet("4","Planet 4", "Climate 4", "Terrain 4");
        missingDataPlanet = new Planet("2", "Planet 2", null, null);
        sameIdPlanet = new Planet("1", "Planet 1","Climate 1","Terrain 1");
        nonExistingPlanet = new Planet("99", "Planet 99", "Climate 99", "Terrain 99");

        repository.save(planet);
        repository.save(planet2);
        repository.save(planet3);
        repository.save(planet4);

    }

    @AfterEach
    private void TearDown(){

        repository.deleteAll();

    }

    @Test
    @DisplayName("Tests the POST endpoint of PlanetController.")
    public void createPlanetTest() throws Exception {

        Planet planetMock = new Planet("5","Mock Planet", "Mock climate", "Mock terrain");

        mockMvc.perform(post(endpoint)
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(planetMock)))
                .andExpect(status().isCreated());

    };

    @Test
    @DisplayName("Tests the GET endpoint of PlanetController with a Planet id.")
    public void readPlanetByIdTest() throws Exception {

        mockMvc.perform(get(endpoint + "/" + planet.getId()))
                .andExpect(status().isOk());

    };

    @Test
    @DisplayName("Tests the GET endpoint of PlanetController with an invalid Planet id.")
    public void readPlanetByIdWithNonExistingIdTest() throws Exception {

        mockMvc.perform(get(endpoint + "/" + nonExistingPlanet.getId()))
                .andExpect(status().isNotFound());

    };

    @Test
    @DisplayName("Tests the GET endpoint of PlanetController with a Planet name.")
    public void readPlanetByNameTest() throws Exception {

        mockMvc.perform(get(endpoint).param("name",planet.getName()))
                .andExpect(status().isOk());

    };

    @Test
    @DisplayName("Tests the PUT endpoint of PlanetController.")
    public void updatePlanetTest() throws Exception {

        Planet planetMock = new Planet("1","Mock Planet", "Mock climate", "Mock terrain");

        mockMvc.perform(put(endpoint + "/" + planet.getId())
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(planetMock)))
                .andExpect(status().isOk());

    };

    @Test
    @DisplayName("Tests the DELETE endpoint of PlanetController.")
    public void deletePlanetTest() throws Exception {

        mockMvc.perform(delete(endpoint + "/" + planet.getId()))
                .andExpect(status().isOk());

    };

    @Test
    @DisplayName("Tests the DELETE endpoint of PlanetController with and invalid Planet id.")
    public void deletePlanetWithNonExistingIdTest() throws Exception {

        mockMvc.perform(delete(endpoint + "/" + nonExistingPlanet.getId()))
                .andExpect(status().isNotFound());

    };

}
