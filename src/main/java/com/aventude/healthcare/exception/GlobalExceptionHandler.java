package com.aventude.healthcare.exception;

import com.aventude.healthcare.constants.HttpConstants;
import com.aventude.healthcare.dto.response.ExceptionResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

import static com.aventude.healthcare.constants.ErrorConstant.DOCTOR_NOT_FOUND_ERROR;
import static com.aventude.healthcare.constants.ErrorConstant.INTERNAL_SERVER_ERROR;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(Exception.class)
  public ResponseEntity<ExceptionResponse> handleException(Exception ex, WebRequest webRequest) {
    if (ex instanceof DoctorNotFoundException) {
      return handleDoctorNotFoundError(ex, webRequest);
    } else if (ex instanceof PatientNotFoundException) {
      return handlePatientNotFoundException(ex, webRequest);
    } else if (ex instanceof UserNotFoundException) {
      return handleUserFoundException(ex, webRequest);
    } else if (ex instanceof ConsultationNotFoundException) {
      return handleConsultationFoundException(ex, webRequest);
    } else {
      return handleGenericException(ex, webRequest);
    }
  }

  private ResponseEntity<ExceptionResponse> handleDoctorNotFoundError(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(HttpStatus.NOT_FOUND, DOCTOR_NOT_FOUND_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handleGenericException(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handleUserFoundException(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handleConsultationFoundException(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> handlePatientNotFoundException(
      Exception ex, WebRequest webRequest) {
    return buildExceptionResponse(
        HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR, ex, webRequest);
  }

  private ResponseEntity<ExceptionResponse> buildExceptionResponse(
      HttpStatus httpStatus, String error, Throwable ex, WebRequest webRequest) {
    Date timestamp = new Date(System.currentTimeMillis());
    ExceptionResponse exceptionResponse =
        new ExceptionResponse(
            timestamp,
            httpStatus.toString(),
            error,
            ex.getMessage(),
            webRequest.getDescription(false).replace(HttpConstants.URL + ":", ""));
    HttpHeaders headers = new HttpHeaders();
    headers.set(HttpConstants.ACCEPT, HttpConstants.APPLICATION_JSON);
    log.error(ex.getMessage(), ex);
    return new ResponseEntity<>(exceptionResponse, headers, httpStatus);
  }
}
