package com.albuquerque.david.StarWarsJavaApi.repository;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlanetRepository extends MongoRepository<Planet, String> {
    Optional<Planet> findByName(String name);
}
