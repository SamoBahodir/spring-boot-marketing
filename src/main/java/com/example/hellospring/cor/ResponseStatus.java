package com.example.hellospring.cor;

import com.example.hellospring.cor.constant.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    USER_NOT_FOUND(3, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXIST(4, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_EQUALS(5, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(6, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    ;

    private final Integer status;
    private final MessageType messageType;
    private final HttpStatus httpStatus;
}
