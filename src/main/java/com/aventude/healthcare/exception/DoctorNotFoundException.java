package com.aventude.healthcare.exception;

import lombok.Getter;

@Getter
public class DoctorNotFoundException extends Exception{
    public DoctorNotFoundException(String message){
        super(message);
    }
}
