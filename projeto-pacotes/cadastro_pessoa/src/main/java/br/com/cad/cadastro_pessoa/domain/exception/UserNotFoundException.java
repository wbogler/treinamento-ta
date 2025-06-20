package br.com.cad.cadastro_pessoa.domain.exception;

public class UserNotFoundException extends DefaultException{

    public UserNotFoundException(){
        super(ErrorType.USER_NOT_FOUND);
    }
}
