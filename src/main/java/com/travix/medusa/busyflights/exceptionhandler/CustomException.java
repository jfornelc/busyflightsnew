package com.travix.medusa.busyflights.exceptionhandler;

public class CustomException extends RuntimeException {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * The error message.
     */
    private String errorMessage;

    private int errorCode;

    /**
     * Gets the error message.
     *
     * @return the error message
     */
    public String getErrorMessage() {
        return errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
    }

    /**
     * Instantiates a new customer exception.
     *
     * @param errorMessage the error message
     */
    public CustomException(String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
    }

    public CustomException(int errorCode, String errorMessage) {
        super(errorMessage);
        this.errorMessage = errorMessage;
        this.errorCode = errorCode;
    }

    /**
     * Instantiates a new customer exception.
     */
    public CustomException() {
        super();
    }

    public CustomException(Exception e) {
        super(e);
    }

}