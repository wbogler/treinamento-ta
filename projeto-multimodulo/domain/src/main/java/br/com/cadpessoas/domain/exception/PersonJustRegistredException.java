package br.com.cadpessoas.domain.exception;

public class PersonJustRegistredException extends DefaultException{

    public PersonJustRegistredException(){
        super(ErrorType.PERSON_JUST_REGISTRED);
    }
}
