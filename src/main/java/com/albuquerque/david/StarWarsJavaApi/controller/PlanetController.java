package com.albuquerque.david.StarWarsJavaApi.controller;

import com.albuquerque.david.StarWarsJavaApi.data.model.Planet;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class PlanetController {

    private final String PlanetEndpoint = "/planet";

    @PostMapping(PlanetEndpoint)
    public void createPlanet(@RequestBody Planet planet){};

    @GetMapping(PlanetEndpoint)
    public void readPlanet(@RequestParam(required = false) Long id){};

    @PutMapping(PlanetEndpoint)
    public void updatePlanet(@RequestBody Planet planet, @RequestParam(required = true) Long id){};

    @DeleteMapping(PlanetEndpoint)
    public void deletePlanet(@RequestParam(required = true) Long id){};

}
