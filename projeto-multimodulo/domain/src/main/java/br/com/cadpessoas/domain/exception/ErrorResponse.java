package br.com.cadpessoas.domain.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String code;
    private String title;
    private String message;
}
