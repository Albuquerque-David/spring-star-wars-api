package com.albuquerque.david.StarWarsJavaApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlanetMissingDataException extends RuntimeException {

    public PlanetMissingDataException(String exception){
        super(exception);
    }

}
