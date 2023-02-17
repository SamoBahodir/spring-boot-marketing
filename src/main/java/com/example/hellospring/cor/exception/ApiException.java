package com.example.hellospring.cor.exception;

import com.example.hellospring.cor.ResponseStatus;

public class ApiException extends RuntimeException {
    public ApiException(ResponseStatus roleNotFound) {
    }

    public ApiException(String message) {
    }
}
