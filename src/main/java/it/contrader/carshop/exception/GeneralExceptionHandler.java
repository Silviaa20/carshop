package it.contrader.carshop.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice //indica che qualsiasi eccezione sollevata dai metodi del controller è gestita in questa classe
public class GeneralExceptionHandler {
    @ExceptionHandler(UserNotFoundException.class)
    //questo metodo gestisce se viene invocato dal controller il tipo di eccezioni specificate sopra tra le () che comunque dobbiamo creare a meno che non usiamo un'eccezione generica (ex.RuntimeException)
    public ResponseEntity<String> userNotFound(UserNotFoundException ex){ //passo come parametro del metodo l'eccezione che viene sollevata nel controller
        return new ResponseEntity<>(ex.getMessage() , HttpStatus.NOT_FOUND);
    } //creo e ritorno una response entity al client

}
