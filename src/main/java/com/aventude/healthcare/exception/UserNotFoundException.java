package com.aventude.healthcare.exception;

import lombok.Getter;

@Getter
public class UserNotFoundException extends Exception{
    public UserNotFoundException(String message){
        super(message);
    }
}
