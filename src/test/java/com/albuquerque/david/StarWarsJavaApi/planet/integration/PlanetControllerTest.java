package com.albuquerque.david.StarWarsJavaApi.planet.integration;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.bind.annotation.RequestBody;

@WebMvcTest
public class PlanetControllerTest {

    private final String PlanetEndpoint = "/planet";

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @BeforeEach
    private void SetUp(){

    }

    @Test
    @DisplayName("Tests the POST endpoint of PlanetController.")
    public void createPlanetTest(){};

    @Test
    @DisplayName("Tests the GET endpoint of PlanetController with a Planet id.")
    public void readPlanetByIdTest(){};

    @Test
    @DisplayName("Tests the GET endpoint of PlanetController with an invalid Planet id.")
    public void readPlanetByIdWithNonExistingIdTest(){};

    @Test
    @DisplayName("Tests the GET endpoint of PlanetController with a Planet name.")
    public void readPlanetByNameTest(){};

    @Test
    @DisplayName("Tests the PUT endpoint of PlanetController.")
    public void updatePlanetTest(){};

    @Test
    @DisplayName("Tests the DELETE endpoint of PlanetController.")
    public void deletePlanetTest(){};

    @Test
    @DisplayName("Tests the DELETE endpoint of PlanetController with and invalid Planet id.")
    public void deletePlanetWithNonExistingIdTest(){};

}
