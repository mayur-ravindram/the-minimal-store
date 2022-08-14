package com.learner.theArtifact.exception;

public class ProductAlreadyExistException extends ProductException{
    public ProductAlreadyExistException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }
}
