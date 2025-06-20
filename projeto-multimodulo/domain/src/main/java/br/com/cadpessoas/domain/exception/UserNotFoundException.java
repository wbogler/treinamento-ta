package br.com.cadpessoas.domain.exception;

public class UserNotFoundException extends DefaultException{

    public UserNotFoundException(){
        super(ErrorType.USER_NOT_FOUND);
    }
}
