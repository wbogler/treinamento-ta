package br.com.cad.cadastro_pessoa.domain.exception;

public class PersonJustRegistredException extends DefaultException{

    public PersonJustRegistredException(){
        super(ErrorType.PERSON_JUST_REGISTRED);
    }
}
