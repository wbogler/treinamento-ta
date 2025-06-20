package br.com.cad.cadastro_pessoa.domain.exception;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MissingRequestHeaderException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.util.Collections;
import java.util.List;
import java.util.Map;

@ControllerAdvice
@AllArgsConstructor
@Slf4j
public class RestExceptionHandler {

    private static final String HTTP_ERROR_MESSAGE = "HTTP Error";

    private static ErrorResponse getErrorResponse(DefaultException ex) {
        return ErrorResponse.builder()
                .code(ex.getErrorCode())
                .title(ex.getResponseTitle())
                .message(ex.getResponseMessage())
                .build();
    }

    @ExceptionHandler({DefaultException.class})
    public ResponseEntity<ErrorResponse> customExceptionHandler(DefaultException ex, WebRequest req) {
        logError(ex);
        return getResponse(ex);
    }

    @ExceptionHandler({Exception.class})
    public ResponseEntity<ErrorResponse> genericExceptionHandler(DefaultException ex, WebRequest req) {
        logError(ex);
        return getResponse(ex);
    }

    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    public ResponseEntity<ErrorResponse> methodNotSupported(HttpRequestMethodNotSupportedException ex, WebRequest req) {
        logError(ex);
        return getResponse(new InvalidParameterException(), Map.of("*", List.of("Method not allowed")));
    }

    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public ResponseEntity<ErrorResponse> methodNotSupported(HttpMediaTypeNotSupportedException ex, WebRequest req) {
        logError(ex);
        return getResponse(new InvalidParameterException(), Map.of("*", List.of("Content-Type not allowed")));
    }

    @ExceptionHandler({MissingRequestHeaderException.class})
    public ResponseEntity<ErrorResponse> missingRequestHeaderException(MissingRequestHeaderException ex, WebRequest req) {
        final var errors = Map.of(ex.getHeaderName(), Collections.singletonList("header obrigatório"));
        logError(ex);
        return getResponse(new InvalidParameterException(), errors);
    }

    private ResponseEntity<ErrorResponse> getResponse(DefaultException ex) {
        final var errorResponse = getErrorResponse(ex);
        return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
    }

    private ResponseEntity<ErrorResponse> getResponse(DefaultException ex, Map<String,List<String>> errors) {
        final var errorResponse = getErrorResponse(ex);
        return ResponseEntity.status(ex.getStatusCode()).body(errorResponse);
    }

    private void logError(Exception ex) {
        log.error("Message= HTTPError ex={} message={}", ex.getClass().getSimpleName(), ex.getMessage());
    }
}
