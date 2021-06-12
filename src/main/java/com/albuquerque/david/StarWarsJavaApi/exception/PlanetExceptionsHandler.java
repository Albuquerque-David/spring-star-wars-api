package com.albuquerque.david.StarWarsJavaApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component("PlanetExceptionsHandler")
public class PlanetExceptionsHandler {

    @ExceptionHandler(value = PlanetMissingDataException.class)
    public ResponseEntity<Object> PlanetMissingDataException(PlanetMissingDataException exception) {
        return new ResponseEntity<>("Missing data on Planet entity body.", HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = PlanetNotFoundException.class)
    public ResponseEntity<Object> PlanetNotFoundException(PlanetNotFoundException exception){
        return new ResponseEntity<>("Planet not found", HttpStatus.NOT_FOUND);
    }

}
