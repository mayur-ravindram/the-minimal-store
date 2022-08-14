package com.learner.theArtifact.exception;

public class InvalidUserException extends ProductException {
    public InvalidUserException(String invalid_credentials) {
        super("401",invalid_credentials);
    }
}
