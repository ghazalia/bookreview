package com.example.bookreview.exception;

public class DataAlreadyExistException extends RuntimeException {
    public DataAlreadyExistException() {
        super();
    }

    public DataAlreadyExistException(String cause) {
        super(cause);
    }
}
