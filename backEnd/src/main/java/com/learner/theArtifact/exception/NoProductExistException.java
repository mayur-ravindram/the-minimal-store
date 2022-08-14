package com.learner.theArtifact.exception;

public class NoProductExistException extends ProductException {
    public NoProductExistException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
