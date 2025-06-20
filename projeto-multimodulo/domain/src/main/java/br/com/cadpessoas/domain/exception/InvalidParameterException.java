package br.com.cadpessoas.domain.exception;

public class InvalidParameterException extends DefaultException{

    public InvalidParameterException() {
        super(ErrorType.INVALID_PARAMETERS);
    }
}