package com.albuquerque.david.StarWarsJavaApi.planet.unit;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.exception.PlanetMissingDataException;
import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import com.mongodb.lang.NonNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

/**
 *
 * Unit tests for the PlanetRepository class.
 *
 */
public class PlanetRepositoryTest {

    PlanetRepository repository;

    public PlanetRepositoryTest(PlanetRepository repository){
        this.repository = repository;
    }

    @BeforeEach
    private void SetUp(){

    }

    @Test
    @DisplayName("Count all the Planet entities in the database.")
    public void countPlanetsTest(){};

    @Test
    @DisplayName("Receives a Planet entity and persists it in the database.")
    public void persistPlanetTest(Planet planet){};

    @Test
    @DisplayName("Receives a List<Planet> and persists all the entities in the database.")
    public void persistAllPlanetsTest(List<Planet> planets){};

    @Test
    @DisplayName("Receives a Planet entity with invalid data and should trigger an exception.")
    public void persistPlanetWithInvalidDataTest(Planet invalidPlanet){};

    @Test
    @DisplayName("Receives an id and search the Planet with the correspondent id.")
    public void findPlanetByIdTest(Long id){};

    @Test
    @DisplayName("Receives an invalid Object id of Planet. Should trigger an exception.")
    public void findPlanetWithInvalidIdTest(Object invalidId){};

    @Test
    @DisplayName("Receives an id of Planet that is not in the database. Should trigger an exception")
    public void findPlanetWithNonExistingIdTest(Long nonExistingId){};

    @Test
    @DisplayName("Receives a Planet entity and search for it in the database.")
    public void findPlanetByEntityTest(Planet planet){};

    @Test
    @DisplayName("Search for all the Planet entities in the database.")
    public void findAllPlanetsTest(){};

    @Test
    @DisplayName("Receives the name of a Planet and search it in the database.")
    public void searchPlanetByNameTest(String planetName){};

    @Test
    @DisplayName("Receives an invalid Object name. Should trigger an exception.")
    public void searchPlanetByNameWithInvalidNameTest(Object invalidName){};

    @Test
    @DisplayName("Receives the name of a non existing Planet. Should trigger an exception.")
    public void searchPlanetByNameWithNonExistingPlanetTest(String planetName){};

    @Test
    @DisplayName("Receive an id and check if exists a Planet with the correspondent id.")
    public void existsPlanetByIdTest(Long id){};

    @Test
    @DisplayName("Receives and invalid Object id of Planet. Should trigger an exception.")
    public void existsPlanetByIdWithInvalidIdTest(Object invalidId){};

    @Test
    @DisplayName("Receives an id of a non existing Planet. Should trigger an exception.")
    public void existsPlanetByIdWithNonExistingIdTest(Long id){};

    @Test
    @DisplayName("Receives an id of Planet and deletes it from the database.")
    public void deletePlanetByIdTest(Long id){};

    @Test
    @DisplayName("Receives an invalid Object id of Planet. Should trigger an exception.")
    public void deletePlanetByIdWithInvalidIdTest(Object invalidId){};

    @Test
    @DisplayName("Receives an id of a non existing Planet. Should trigger an exception.")
    public void deletePlanetByIdWithNonExistingIdTest(Long id){};

    @Test
    @DisplayName("Deletes all the Planet entities in the database.")
    public void deleteAllPlanetsTest(){};

}
