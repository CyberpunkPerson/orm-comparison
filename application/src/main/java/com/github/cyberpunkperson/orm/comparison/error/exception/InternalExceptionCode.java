package com.github.cyberpunkperson.orm.comparison.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum InternalExceptionCode implements ExceptionCode {

    DEFAULT_INTERNAL_ERROR("InternalServerError", "Internal server error");

    private final String code;

    private final String message;

}
