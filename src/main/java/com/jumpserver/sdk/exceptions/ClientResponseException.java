package com.jumpserver.sdk.exceptions;


public class ClientResponseException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public ClientResponseException(String message) {
        super(message);
    }

}
