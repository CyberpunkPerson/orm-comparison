package com.github.cyberpunkperson.orm.comparison.error.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum ValidationExceptionCode implements ExceptionCode {

    BAD_REQUEST("BadRequest", "Bad request"),
    METHOD_NOT_ALLOWED("MethodNotAllowed", "Method Not Allowed");


    private final String code;

    private final String message;

}
