package it.contrader.carshop.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

public abstract class GenericException {

    @ExceptionHandler({InvalidCredentials.class})
    public ResponseEntity<String> InvalidCredential(InvalidCredentials ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.UNAUTHORIZED);
    }
}
