package com.github.cyberpunkperson.orm.comparison.error.handler;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

import java.util.HashMap;
import java.util.Map;

import static com.github.cyberpunkperson.orm.comparison.error.exception.InternalExceptionCode.DEFAULT_INTERNAL_ERROR;
import static com.github.cyberpunkperson.orm.comparison.error.exception.SecurityExceptionCode.UNAUTHORIZED;
import static com.github.cyberpunkperson.orm.comparison.error.exception.ValidationExceptionCode.BAD_REQUEST;
import static com.github.cyberpunkperson.orm.comparison.error.exception.ValidationExceptionCode.METHOD_NOT_ALLOWED;

@Getter
@ConstructorBinding
@RequiredArgsConstructor
@ConfigurationProperties(prefix = "response.error")
public class ErrorResponseProperties {

    private final Map<String, String> messages = new HashMap<>() {{
        put(DEFAULT_INTERNAL_ERROR.getCode(), "Internal server error");
        put(BAD_REQUEST.getCode(), "Incorrect input data");
        put(METHOD_NOT_ALLOWED.getCode(), "Method not supported");
        put(UNAUTHORIZED.getCode(), "Non authorized request");
    }};
}
