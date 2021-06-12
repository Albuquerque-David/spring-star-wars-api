package com.albuquerque.david.StarWarsJavaApi.planet.unit;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 *
 * Unit tests for the PlanetRepository class.
 *
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
public class PlanetRepositoryTest {

    @Autowired
    PlanetRepository repository;

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
    @DisplayName("Count all the Planet entities in the database.")
    public void countPlanetsTest(){

        assertEquals(4,repository.count());

    };

    @Test
    @DisplayName("Receives a Planet entity and persists it in the database.")
    public void persistPlanetTest(){

        Planet planetMock = new Planet("5","Mock Planet", "Mock climate", "Mock terrain");
        assertEquals(planetMock, repository.save(planetMock));

    };

    @Test
    @DisplayName("Receives a List<Planet> and persists all the entities in the database.")
    public void persistAllPlanetsTest(){

        Planet planetMock1 = new Planet("5","Mock Planet 1", "Mock climate 1", "Mock terrain 1");
        Planet planetMock2 = new Planet("6","Mock Planet 2", "Mock climate 2", "Mock terrain 2");
        Planet planetMock3 = new Planet("7","Mock Planet 3", "Mock climate 3", "Mock terrain 3");

        List<Planet> mockPlanets = new ArrayList<>();
        mockPlanets.add(planetMock1);
        mockPlanets.add(planetMock2);
        mockPlanets.add(planetMock3);

        assertEquals(mockPlanets, repository.saveAll(mockPlanets));

    };

    @Test
    @DisplayName("Receives an id and search the Planet with the correspondent id.")
    public void findPlanetByIdTest(){

        assertEquals(planet, repository.findById("1").get());

    };


    @Test
    @DisplayName("Receives a Planet entity and search for it in the database.")
    public void findPlanetByEntityTest(){

        assertEquals(planet, repository.findOne(Example.of(planet)).get());

    };

    @Test
    @DisplayName("Search for all the Planet entities in the database.")
    public void findAllPlanetsTest(){

        List<Planet> allPlanets = new ArrayList<>();
        allPlanets.add(planet);
        allPlanets.add(planet2);
        allPlanets.add(planet3);
        allPlanets.add(planet4);

        assertEquals(allPlanets, repository.findAll());
    };

    @Test
    @DisplayName("Receives the name of a Planet and search it in the database.")
    public void searchPlanetByNameTest(){
        Planet planetByName = new Planet(null, planet.getName(),null,null);
        assertEquals(planet, repository.findOne(Example.of(planetByName)).get());
    };



    @Test
    @DisplayName("Receive an id and check if exists a Planet with the correspondent id.")
    public void existsPlanetByIdTest(){

        assertEquals(true,repository.existsById(planet.getId()));

    };

    @Test
    @DisplayName("Receives an id of Planet and deletes it from the database.")
    public void deletePlanetByIdTest(){
        repository.deleteById(planet.getId());
    };

    @Test
    @DisplayName("Deletes all the Planet entities in the database.")
    public void deleteAllPlanetsTest(){

        repository.deleteAll();

    };

}
