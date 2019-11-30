package com.bridgelab.censusanalyserTests;

public class CSVUserException extends Exception {
    enum ExceptionType{
        FILE_NOT_FOUND,BINDING_PROBLEM_AT_RAUNTIME;
    }
    ExceptionType type;

    public CSVUserException(ExceptionType type, String message ) {
        super(message);
        this.type = type;
    }

    public CSVUserException(ExceptionType type, String message,  Throwable cause) {
        super(message, cause);
        this.type = type;
    }
}
