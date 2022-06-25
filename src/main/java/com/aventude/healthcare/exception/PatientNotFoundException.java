package com.aventude.healthcare.exception;

import lombok.Getter;

@Getter
public class PatientNotFoundException extends Exception{
    public PatientNotFoundException(String message){
        super(message);
    }
}
