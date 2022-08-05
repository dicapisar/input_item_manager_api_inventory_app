package com.dicapisar.inputItemManager.exceptions;

import org.springframework.http.HttpStatus;

public class SessionErrorException extends InputItemException{
    public SessionErrorException() {
        super("Session error, try to login again.", HttpStatus.FORBIDDEN);
    }
}
