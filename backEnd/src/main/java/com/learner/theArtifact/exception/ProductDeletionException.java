package com.learner.theArtifact.exception;

public class ProductDeletionException extends ProductException {
    public ProductDeletionException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
