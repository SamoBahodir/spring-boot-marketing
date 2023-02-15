package com.example.hellospring.cor.exception;

import com.example.hellospring.cor.ResponseStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiException extends RuntimeException {
    private ResponseStatus responseStatus;
}
