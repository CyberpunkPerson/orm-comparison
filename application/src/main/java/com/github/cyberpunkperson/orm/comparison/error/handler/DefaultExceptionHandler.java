package com.github.cyberpunkperson.orm.comparison.error.handler;

import com.github.cyberpunkperson.orm.comparison.error.exception.ValidationExceptionCode;
import com.github.cyberpunkperson.orm.comparison.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.TypeMismatchException;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

import java.util.Map;

import static com.github.cyberpunkperson.orm.comparison.error.exception.InternalExceptionCode.DEFAULT_INTERNAL_ERROR;
import static java.util.stream.Collectors.toMap;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.status;

@Slf4j
@ControllerAdvice
@RequiredArgsConstructor
class DefaultExceptionHandler {

    private final ErrorResponseBuilder errorBuilder;


    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exception) {
        BindingResult bindingResult = exception.getBindingResult();
        Map<String, String> fieldErrorMap = bindingResult.getFieldErrors().stream()
                .collect(toMap(FieldError::getField, DefaultMessageSourceResolvable::getDefaultMessage));
        return status(BAD_REQUEST)
                .body(errorBuilder.build(ValidationExceptionCode.BAD_REQUEST)
                        .errorDetails(fieldErrorMap));
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ErrorResponse> handleMethodNotSupportedException() {
        return status(METHOD_NOT_ALLOWED)
                .body(errorBuilder.build(ValidationExceptionCode.METHOD_NOT_ALLOWED));
    }

    @ExceptionHandler({
            ServletRequestBindingException.class,
            TypeMismatchException.class,
            HttpMessageNotReadableException.class,
            HttpMessageNotWritableException.class,
            MissingServletRequestPartException.class,
            BindException.class,
            MissingServletRequestParameterException.class,
            javax.validation.ValidationException.class
    })
    public ResponseEntity<Object> handleException(Throwable throwable, WebRequest request) {
        log.error(BAD_REQUEST.toString(), throwable);
        return status(BAD_REQUEST).body(errorBuilder.build(ValidationExceptionCode.BAD_REQUEST));
    }

    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleUndefinedException(Throwable throwable) {
        return status(INTERNAL_SERVER_ERROR)
                .body(errorBuilder.build(DEFAULT_INTERNAL_ERROR));
    }
}
