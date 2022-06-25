package com.aventude.healthcare.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionResponse {
    private Date timestamp;
    private String status;
    private String error;
    private String message;
    private String path;
}
