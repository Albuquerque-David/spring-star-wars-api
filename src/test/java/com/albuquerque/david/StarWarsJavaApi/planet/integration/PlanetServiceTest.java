package com.albuquerque.david.StarWarsJavaApi.planet.integration;
import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PlanetServiceTest {

    @BeforeEach
    private void SetUp(){

    }

    @Test
    @DisplayName("Receives a Planet entity and creates it in the database")
    public void createPlanetTest(Planet planet){};

    @Test
    @DisplayName("Receives a Planet entity with missing data. Should trigger an exception.")
    public void createPlanetWithMissingDataTest(Planet planet){};

    @Test
    @DisplayName("Receives the id of a Planet entity and search for it in the database.")
    public void readPlanetTest(Long id){};

    @Test
    @DisplayName("Receives the id of a non existing Planet entity. Should trigger and exception.")
    public void readPlanetWithNonExistingIdTest(){};

    @Test
    @DisplayName("Search for all the Planet entities in the database.")
    public void readAllPlanetsTest(){};

    @Test
    @DisplayName("Receives an existing Planet entity and updates with the new data.")
    public void updatePlanetTest(Planet planet){};

    @Test
    @DisplayName("Receives an existing Planet entity with missing data. Should trigger an exception.")
    public void updatePlanetWithMissingData(Planet planet){};

    @Test
    @DisplayName("Receives an id of a Planet entity and deletes it from the database.")
    public void deletePlanetTest(Long id){};

    @Test
    @DisplayName("Receives an id of a non existing Planet entity. Should trigger an exception.")
    public void deletePlanetWithNonExistingId(Long id){};

}
