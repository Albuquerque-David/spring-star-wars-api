package com.albuquerque.david.StarWarsJavaApi.config;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.repository.PlanetRepository;
import com.albuquerque.david.StarWarsJavaApi.utils.SWApiUtils;
import com.github.cloudyrock.mongock.ChangeLog;
import com.github.cloudyrock.mongock.ChangeSet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@ChangeLog
public class DatabaseChangeLog {

    @ChangeSet(order = "001", id = "seedDatabase", author = "David", runAlways = true)
    public void seedDatabase(PlanetRepository planetRepository) {
        List<Planet> planetList = new ArrayList<>();
        planetList.addAll(SWApiUtils.getAllPlanets());
        planetRepository.saveAll(planetList);
    }
}
