package com.github.cyberpunkperson.orm.comparison.error.handler;

import com.github.cyberpunkperson.orm.comparison.error.exception.ExceptionCode;
import com.github.cyberpunkperson.orm.comparison.model.ErrorResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static java.util.Collections.emptyList;

@Component
@RequiredArgsConstructor
class ErrorResponseBuilder {

    private final ErrorResponseProperties properties;


    public ErrorResponse build(ExceptionCode exceptionCode) {
        return new ErrorResponse()
                .errorId(UUID.randomUUID().toString())
                .errorCode(exceptionCode.getCode())
                .errorMessage(computeErrorMessage(exceptionCode.getCode(), exceptionCode.getMessage()))
                .errorDetails(emptyList());
    }

    private String computeErrorMessage(String exceptionCode, String defaultMessage) {
        return properties.getMessages().getOrDefault(exceptionCode, defaultMessage);
    }
}
