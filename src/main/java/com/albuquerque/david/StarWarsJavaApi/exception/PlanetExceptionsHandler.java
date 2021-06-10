package com.albuquerque.david.StarWarsJavaApi.exception;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Component("PlanetExceptionsHandler")
public class PlanetExceptionsHandler {

    public void PlanetMissingDataException() throws PlanetMissingDataException {

        throw new PlanetMissingDataException();

    }

    public void PlanetNotFoundException() throws PlanetNotFoundException {

        throw new PlanetNotFoundException();
    }

}
