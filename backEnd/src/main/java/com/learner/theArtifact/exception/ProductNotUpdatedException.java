package com.learner.theArtifact.exception;

public class ProductNotUpdatedException extends ProductException {
    public ProductNotUpdatedException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
