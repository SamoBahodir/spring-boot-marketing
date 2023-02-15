package com.example.hellospring.cor;

import com.example.hellospring.cor.constant.MessageType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ResponseStatus {
    INTERNAL_SERVER_ERROR(1, MessageType.ERROR, HttpStatus.INTERNAL_SERVER_ERROR),
    TRANSLATION_NOT_FOUND(2, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    USER_NOT_FOUND(3, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    USER_ALREADY_EXIST(4, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    TRANSLATION_ALREADY_EXIST(5, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    ROLE_NOT_FOUND(6, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    SMS_TEMPLATE_NOT_FOUND(7, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    SMS_TEMPLATE_ALREADY_EXIST(8, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    DOCUMENT_NUMBER_NOT_FOUND(9, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    COUNTRY_NOT_FOUND(10,MessageType.ERROR ,HttpStatus.BAD_REQUEST ),
    ORGANIZATION_NOT_FOUND(11,MessageType.ERROR ,HttpStatus.BAD_REQUEST ),
    DELETED(12,MessageType.ERROR ,HttpStatus.BAD_REQUEST ),
    FILE_NOT_FOUND(13,MessageType.ERROR ,HttpStatus.BAD_REQUEST ),
    APPLICATION_NOT_FOUND(14,MessageType.ERROR ,HttpStatus.BAD_REQUEST ),
    SOATO_NOT_FOUND(15,MessageType.ERROR ,HttpStatus.BAD_REQUEST ),
    API_KEY_DID_NOT_MATCH(16, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    PASSWORD_NOT_EQUALS(17, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    FACE_FILE_REQUIRED(18, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    FINGER_FILE_REQUIRED(19, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    SIGNATURE_FILE_REQUIRED(20, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    OTP_NOT_FOUND(21, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    OTP_TIME_UP_ERROR(22, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    OTP_CODE_ERROR(23, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    REGISTER_NOT_FOUND(24, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    REGISTER_NOT_ACTIVE(25, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    REGISTER_DELETED(26, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    REGISTER_SUSPENSION(27, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    APPLICATION_ALREADY_SUCCESSFUL(28, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    APPLICATION_ALREADY_CANCELED(29, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    APPLICATION_ALREADY_REJECT(30, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    MOBILE_ID_ALREADY_EXISTS(31, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    ONE_ID_REQUIRED(32, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    MOBILE_ID_REQUIRED(33, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    REGISTER_ALREADY_EXISTS(34, MessageType.ERROR, HttpStatus.BAD_REQUEST),
    ;

    private final Integer status;
    private final MessageType messageType;
    private final HttpStatus httpStatus;
}
