package com.zemoso.greencommute.exception;

public class CityNotFoundException extends RuntimeException{

    public CityNotFoundException(String message) {
        super(message);
    }

}
