package com.albuquerque.david.StarWarsJavaApi.controller;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import com.albuquerque.david.StarWarsJavaApi.exception.PlanetIdNotUpdatableException;
import com.albuquerque.david.StarWarsJavaApi.service.PlanetService;
import io.swagger.annotations.ApiModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@ApiModel("Planet")
@RequestMapping("/api/v1/planet")
public class PlanetController {

    private final String swapiUri = "https://swapi.dev/api/";

    private PlanetService service;

    public PlanetController(PlanetService service){
        this.service = service;
    }

    @PostMapping
    public ResponseEntity createPlanet(@RequestBody Planet planet){

        Planet response = service.createPlanet(planet);
        return new ResponseEntity(response,HttpStatus.CREATED);

    };

    @GetMapping
    public ResponseEntity readAllPlanets(@RequestParam(value = "name", required = false) String name){

        if(name != null)
            return new ResponseEntity(service.readPlanet(name),HttpStatus.OK);

        List<Planet> response = service.readAllPlanets();
        return new ResponseEntity(response, HttpStatus.OK);

    };

    @GetMapping("/{id}")
    public ResponseEntity readPlanet(@PathVariable(value = "id") Long id){

        Planet response = service.readPlanet(id);
        return new ResponseEntity(response, HttpStatus.OK);

    };

    @PutMapping("/{id}")
    public ResponseEntity updatePlanet(@RequestBody Planet planet, @PathVariable("id") Long id){

        if(planet.getId() == null)
            planet.setId(id.toString());

        if(!planet.getId().equals(id.toString()))
            throw new PlanetIdNotUpdatableException("Cannot change the Planet ID.");

        Planet response = service.updatePlanet(planet);
        return new ResponseEntity(response,HttpStatus.OK);

    };

    @DeleteMapping("/{id}")
    public ResponseEntity deletePlanet(@PathVariable("id") Long id){

        service.deletePlanet(id);
        return new ResponseEntity(HttpStatus.OK);

    };

}
