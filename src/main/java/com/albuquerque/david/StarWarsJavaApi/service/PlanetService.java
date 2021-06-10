package com.albuquerque.david.StarWarsJavaApi.service;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlanetService {

    private PlanetRepository repository;

    public PlanetService(PlanetRepository repository){
        this.repository = repository;
    }


    /**
     *
     * Creates a Planet object in the database.
     * The method will return the created object.
     * @param planet the Planet data to be created.
     * @return the created Planet, if successful.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetMissingDataException
     *
     */
    public Planet createPlanet(Planet planet){ return null; };

    /**
     *
     * Search for a Planet with the specified id in the database.
     * @param id the Planet id to be searched.
     * @return the Planet with the correspondent id param, if founded.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException
     *
     */
    public Planet readPlanet(Long id){ return null; };

    /**
     *
     * Search for all the Planet objects in the database.
     * @return an java.util.List object of Planet with all Planet objects.
     *
     */
    public List<Planet> readAllPlanets(){ return null; };

    /**
     *
     * Updates a Planet object in the database.
     * @param planet the Planet data to be updated.
     * @return the updated Planet, if successful.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetMissingDataException
     *
     */
    public Planet updatePlanet(Planet planet){ return null; };

    /**
     *
     * Deletes a Planet with the specified id in the database.
     * @param id the Planet id to be deleted.
     * @return the deleted Planet, if founded.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException
     *
     */
    public void deletePlanet(Long id){};


}
