package com.aventude.healthcare.exception;

import lombok.Getter;

@Getter
public class ConsultationNotFoundException extends Exception{
    public ConsultationNotFoundException(String message){
        super(message);
    }
}
