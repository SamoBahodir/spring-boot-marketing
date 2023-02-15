package com.example.hellospring.cor.exception;

import com.example.hellospring.cor.response.ErrorResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class IdGovException extends RuntimeException {
    private int httpStatus;
    private ErrorResponse errorResponse;
}
