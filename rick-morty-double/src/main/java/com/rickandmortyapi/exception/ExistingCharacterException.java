package com.rickandmortyapi.exception;

public class ExistingCharacterException extends RuntimeException{
    private String characterName;

    public ExistingCharacterException(String message) {
        super(message);
    }
}
