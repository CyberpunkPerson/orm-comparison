package com.github.cyberpunkperson.orm.comparison.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum SecurityExceptionCode implements ExceptionCode {

    UNAUTHORIZED("Unauthorized", "Unauthorized request");

    private final String code;

    private final String message;

}
