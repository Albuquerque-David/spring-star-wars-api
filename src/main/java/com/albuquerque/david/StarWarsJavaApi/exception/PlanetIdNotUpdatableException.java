package com.albuquerque.david.StarWarsJavaApi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class PlanetIdNotUpdatableException extends RuntimeException {

    public PlanetIdNotUpdatableException(String exception){
        super(exception);
    }

}
