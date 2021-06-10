package com.albuquerque.david.StarWarsJavaApi.dao;

import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import org.springframework.stereotype.Component;

@Component
public class PlanetDAO {

    private PlanetRepository repository;

    public PlanetDAO(PlanetRepository repository){
        this.repository = repository;
    }

}
