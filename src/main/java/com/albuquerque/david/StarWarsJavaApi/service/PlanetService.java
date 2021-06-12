package com.albuquerque.david.StarWarsJavaApi.service;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.exception.PlanetExistsWithIdException;
import com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException;
import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service("com.albuquerque.david.StarWarsJavaApi.service.PlanetService")
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
    public Planet createPlanet(Planet planet){

        if(repository.existsById(planet.getId()))
            throw new PlanetExistsWithIdException("Already exists a Planet with ID " + planet.getId() + ".");

        Planet response = repository.save(planet);
        return response;

    };

    /**
     *
     * Search for a Planet with the specified id in the database.
     * @param id the Planet id to be searched.
     * @return the Planet with the correspondent id param, if founded.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException
     *
     */
    public Planet readPlanet(Long id) throws PlanetNotFoundException {

        Optional<Planet> response = repository.findById(id.toString());
        if(response.isEmpty())
            throw new PlanetNotFoundException("Planet with ID " + id + " not found.");

        return response.get();

    };

    /**
     *
     * Search for a Planet with the specified name in the database.
     * @param name the Planet name to be searched.
     * @return the Planet with the correspondent name param, if founded.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException
     *
     */
    public Planet readPlanet(String name) throws PlanetNotFoundException {

        Optional<Planet> response = repository.findOne(Example.of(new Planet(null,name,null,null)));

        if(response.isEmpty())
            throw new PlanetNotFoundException("Planet with name " + name + " not found.");

        return response.get();

    };

    /**
     *
     * Search for all the Planet objects in the database.
     * @return an java.util.List object of Planet with all Planet objects.
     *
     */
    public List<Planet> readAllPlanets(){
        List<Planet> response = repository.findAll();
        return response;
    };

    /**
     *
     * Updates a Planet object in the database.
     * @param planet the Planet data to be updated.
     * @return the updated Planet, if successful.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetMissingDataException
     *
     */
    public Planet updatePlanet(Planet planet){

        if(repository.existsById(planet.getId().toString()))
            return repository.save(planet);
        else
            throw new PlanetNotFoundException("Planet with ID " + planet.getId() + " not found.");

    };

    /**
     *
     * Deletes a Planet with the specified id in the database.
     * @param id the Planet id to be deleted.
     * @return the deleted Planet, if founded.
     * @throws com.albuquerque.david.StarWarsJavaApi.exception.PlanetNotFoundException
     *
     */
    public void deletePlanet(Long id){

        if(repository.existsById(id.toString()))
            repository.deleteById(id.toString());
        else
            throw new PlanetNotFoundException("Planet with ID " + id.toString() + " not found.");

    };


}
