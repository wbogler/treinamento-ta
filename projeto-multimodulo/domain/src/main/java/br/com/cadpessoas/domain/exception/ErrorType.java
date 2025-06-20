package br.com.cadpessoas.domain.exception;


import lombok.Getter;

@Getter
public enum ErrorType {

    INTERNAL_ERROR(500, "AP001", Constants.INTERNAL_ERROR_TITLE, Constants.INTERNAL_ERROR_MESSAGE),
    USER_NOT_FOUND(404, "AP002", Constants.USER_NOT_FOUND, "Usuário não encontrado"),
    PERSON_JUST_REGISTRED(400, "AP003", "Pessoa cadastrada", "Cadastrar outra pessoa"),

    INVALID_PARAMETERS(
            402,
            "BM001",
            Constants.INVALID_PARAMETER_ERROR_TITLE,
            Constants.INVALID_PARAMETER_ERROR_MESSAGE
    );

    public int getStatusCode() {
        return statusCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getResponseTitle() {
        return responseTitle;
    }

    public String getResponseMessage() {
        return responseMessage;
    }

    ErrorType(int statusCode, String errorCode, String responseTitle, String responseMessage) {
        this.statusCode = statusCode;
        this.errorCode = errorCode;
        this.responseTitle = responseTitle;
        this.responseMessage = responseMessage;
    }


    private final int statusCode;
    private final String errorCode;
    private final String responseTitle;
    private final String responseMessage;

    private static class Constants {
        private static final String INTERNAL_ERROR_TITLE = "Erro interno";
        private static final String INTERNAL_ERROR_MESSAGE = "Tente novamente mais tarde";
        private static final String INVALID_PARAMETER_ERROR_TITLE = "Parametros Invalidos";
        private static final String INVALID_PARAMETER_ERROR_MESSAGE = "Parametros Invalidos";
        private static final String USER_NOT_FOUND = "Usuario não encontrado";
    }


}
