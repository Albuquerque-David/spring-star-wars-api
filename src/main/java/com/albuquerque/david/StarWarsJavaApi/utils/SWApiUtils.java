package com.albuquerque.david.StarWarsJavaApi.utils;

import com.albuquerque.david.StarWarsJavaApi.data.dto.PlanetDTO;
import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class SWApiUtils {

    private static RestTemplate restTemplate;

    private static final String swapiUri = "https://swapi.dev/api/";

    public static List<Planet> getAllPlanets(){
        PlanetDTO response;
        List<Planet> planets = new ArrayList<Planet>();
        restTemplate = new RestTemplate();
        for(Integer i = 0; i <= 60; i++){
            try{
                response = restTemplate.getForObject(swapiUri + "planets/" + i + "/", PlanetDTO.class);
            }
            catch(HttpClientErrorException.NotFound ex){
                response = null;
            }

            if(response != null)
                planets.add(convertPlanetDTOToPlanet(response, i.toString()));

        }

        return planets;

    }

    public static Planet findPlanetById(String id){
        restTemplate = new RestTemplate();
        PlanetDTO response;
        try{
            response = restTemplate.getForObject(swapiUri + "planets/" + id + "/", PlanetDTO.class);
        }
        catch(HttpClientErrorException.NotFound ex){
            response = null;
        }

        return response != null ? convertPlanetDTOToPlanet(response, id) : null;
    };

    public static Planet convertPlanetDTOToPlanet(PlanetDTO planetDTO, String id){
        Planet planet = new Planet(id, planetDTO.getName(), planetDTO.getClimate(), planetDTO.getTerrain());
        planet.setFilms(Arrays.asList(planetDTO.getFilms().clone()));
        return planet;
    }

}
