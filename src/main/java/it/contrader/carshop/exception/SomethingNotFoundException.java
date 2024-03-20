package it.contrader.carshop.exception;

public class SomethingNotFoundException extends RuntimeException{
    public SomethingNotFoundException(String message){
        super(message);
    }
}
