package br.com.cad.cadastro_pessoa.domain.exception;

public class DefaultException extends RuntimeException{

    public ErrorType getErrorType() {
        return errorType;
    }

    private final ErrorType errorType;

    DefaultException(String message, Throwable cause) {
        super(message, cause);
        errorType = ErrorType.INTERNAL_ERROR;
    }

    DefaultException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public String getResponseMessage() {
        return this.errorType.getResponseMessage();
    }

    public String getResponseTitle() {
        return this.errorType.getResponseTitle();
    }

    public String getErrorCode() {
        return this.errorType.getErrorCode();
    }

    public int getStatusCode() {
        return this.errorType.getStatusCode();
    }
}
