package com.learner.theArtifact.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class APIExceptionHandler {

    @ExceptionHandler({ProductAlreadyExistException.class, NoProductExistException.class, ProductNotUpdatedException.class, ProductDeletionException.class, InvalidUserException.class})
    @ResponseStatus(HttpStatus.NOT_ACCEPTABLE)
    public @ResponseBody
    ErrorResponse handleProductException(ProductException exception) {
        return new ErrorResponse(exception.getErrorCode(),exception.getErrorMessage());
    }

}
