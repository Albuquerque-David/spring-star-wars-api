package com.albuquerque.david.StarWarsJavaApi.repository;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {

}
