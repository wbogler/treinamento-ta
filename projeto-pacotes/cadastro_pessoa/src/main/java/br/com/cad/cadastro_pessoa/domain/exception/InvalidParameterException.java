package br.com.cad.cadastro_pessoa.domain.exception;

public class InvalidParameterException extends DefaultException{

    public InvalidParameterException() {
        super(ErrorType.INVALID_PARAMETERS);
    }
}