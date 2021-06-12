package com.albuquerque.david.StarWarsJavaApi.planet.integration;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.exception.PlanetMissingDataException;
import com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException;
import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import com.albuquerque.david.StarWarsJavaApi.service.PlanetService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


/**
 *
 * Integration tests for the PlanetService class.
 *
 */
@DataMongoTest
@ExtendWith(SpringExtension.class)
@ComponentScan("com.albuquerque.david.StarWarsJavaApi")
public class PlanetServiceTest {

    @Autowired
    PlanetService service;

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
    @DisplayName("Receives a Planet entity and creates it in the database")
    public void createPlanetTest(){

        Planet planetMock = new Planet("5","Mock Planet", "Mock climate", "Mock terrain");
        assertEquals(planetMock,service.createPlanet(planetMock));

    };

    @Test
    @DisplayName("Receives a Planet entity with missing data. Should trigger an exception.")
    public void createPlanetWithMissingDataTest(){

        assertThrows(PlanetMissingDataException.class, () -> {
            service.createPlanet(missingDataPlanet);
        });

    };

    @Test
    @DisplayName("Receives the id of a Planet entity and search for it in the database.")
    public void readPlanetByIdTest(){

        assertEquals(planet, service.readPlanet(Long.parseLong(planet.getId())));

    };

    @Test
    @DisplayName("Receives the id of a non existing Planet entity. Should trigger and exception.")
    public void readPlanetWithNonExistingIdTest(){

        assertThrows(PlanetNotFoundException.class, () -> {
            service.readPlanet(Long.parseLong(nonExistingPlanet.getId()));
        });

    };

    @Test
    @DisplayName("Receives the name of a non existing Planet. Should trigger an exception.")
    public void searchPlanetWithNonExistingPlanetNameTest(){

        assertThrows(PlanetNotFoundException.class, () -> {
            service.readPlanet(nonExistingPlanet.getName());
        });

    };

    @Test
    @DisplayName("Search for all the Planet entities in the database.")
    public void readAllPlanetsTest(){

        List<Planet> allPlanets = new ArrayList<>();
        allPlanets.add(planet);
        allPlanets.add(planet2);
        allPlanets.add(planet3);
        allPlanets.add(planet4);

        assertEquals(allPlanets,service.readAllPlanets());

    };

    @Test
    @DisplayName("Receives an existing Planet entity and updates with the new data.")
    public void updatePlanetTest(){

        Planet planetMock = new Planet("1","Mock Planet", "Mock climate", "Mock terrain");
        assertEquals(planetMock, service.updatePlanet(planetMock));

    };

    @Test
    @DisplayName("Receives an existing Planet entity with missing data. Should trigger an exception.")
    public void updatePlanetWithMissingData(){

        assertThrows(PlanetMissingDataException.class, () -> {
            service.updatePlanet(missingDataPlanet);
        });

    };

    @Test
    @DisplayName("Receives an id of a Planet entity and deletes it from the database.")
    public void deletePlanetTest(){

        service.deletePlanet(Long.parseLong(planet.getId()));

    };

    @Test
    @DisplayName("Receives an id of a non existing Planet entity. Should trigger an exception.")
    public void deletePlanetWithNonExistingId(){
        assertThrows(PlanetNotFoundException.class, () -> {
            service.deletePlanet(Long.parseLong(nonExistingPlanet.getId()));
        });
    };

}
