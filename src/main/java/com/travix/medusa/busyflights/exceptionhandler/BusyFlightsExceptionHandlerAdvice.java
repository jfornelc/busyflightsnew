package com.travix.medusa.busyflights.exceptionhandler;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@ControllerAdvice
public class BusyFlightsExceptionHandlerAdvice {

    @Value("${exception_message}")
    private String exceptionMessage;

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> exceptionHandler(Exception ex) {
        return getResponseEntity(exceptionMessage,
                HttpStatus.INTERNAL_SERVER_ERROR.value(), HttpStatus.BAD_REQUEST);
    }

    /**
     * This method catch @see
     * com.travix.medusa.busyflights.exceptionhadler.CustomException.
     * This is the exception thown by application code whenever it catches any
     * checked exception.
     *
     * @param customException
     *            It is the exception which this method handles.
     * @return This method return json format of @see
     *         com.travix.medusa.busyflights.exceptionhadler.
     *         ErrorResponse, which conatins the explanation of the exception
     *         and error code.
     */
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<ErrorResponse> catchCustomException(CustomException customException) {
        return getResponseEntity(customException.getErrorMessage(),
                customException.getErrorCode(), HttpStatus.PARTIAL_CONTENT);
    }

    public ResponseEntity<ErrorResponse> getResponseEntity(String message, int errorCode, HttpStatus status){
        ErrorResponse errorResponse = new ErrorResponse();
        errorResponse.setMessage(message);
        errorResponse.setErrorCode(errorCode);
        return new ResponseEntity<>(errorResponse, status);
    }

    /**
     * This method catch @see org.springframework.web.method.annotation.
     * MethodArgumentTypeMismatchException. When user request a URL, URL
     * requires some fixed number of inputs. If any inputs is missing then this
     * exception is thown.
     *
     * @param typeMismatchException
     *            It is the exception which this method handles.
     * @return This method return json format of @see
     *         com.travix.medusa.busyflights.exceptionhadlern.
     *         ErrorResponse, which conatins the explanation of the exception
     *         and error code.
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<ErrorResponse> catchMethodArgumentTypeMismatchException(
            MethodArgumentTypeMismatchException typeMismatchException) {

        Pattern pattern1 = Pattern.compile("(\")[A-Za-z]+(\")");
        Pattern pattern2 = Pattern.compile("(')[A-Za-z.]+(')");

        String errorMessage = typeMismatchException.getMessage();

        StringBuilder matchedStr = new StringBuilder();
        Matcher match = pattern1.matcher(errorMessage);
        while (match.find())
            matchedStr.append(match.group() + "##");
        match = pattern2.matcher(errorMessage);
        while (match.find())
            matchedStr.append(match.group() + "##");

        return getResponseEntity(errorMessage,
                HttpStatus.NOT_ACCEPTABLE.value(), HttpStatus.NOT_ACCEPTABLE);
    }
}