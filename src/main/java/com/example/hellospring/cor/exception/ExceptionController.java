//package com.example.hellospring.cor.exception;
//
//import com.google.common.base.CaseFormat;
//import lombok.AllArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.FieldError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.ServletWebRequest;
//import uz.minjust.mobile.id.core.Name;
//import uz.minjust.mobile.id.core.ResponseMessage;
//import uz.minjust.mobile.id.core.ResponseStatus;
//import uz.minjust.mobile.id.core.redis.TranslationRedis;
//import uz.minjust.mobile.id.core.redis.TranslationRedisService;
//import uz.minjust.mobile.id.core.response.ErrorResponse;
//
//import java.util.HashMap;
//import java.util.Map;
//
//@Slf4j
//@RestControllerAdvice
//@AllArgsConstructor
//public class ExceptionController {
//    private final TranslationRedisService translationRedisService;
//
//    @ExceptionHandler(ApiException.class)
//    public ResponseEntity<ErrorResponse> internalServerError(ApiException e) {
//        ResponseStatus responseStatus = e.getResponseStatus();
//        log.error("Api exception status {}  ", responseStatus);
//        String tag = responseStatus.name();
//        TranslationRedis translation = translationRedisService.getByTag(tag);
//        Name name = translation != null ? translation.getName() : new Name(tag, tag, tag, tag);
//        return ResponseEntity
//                .status(responseStatus.getHttpStatus())
//                .body(ErrorResponse.builder()
//                        .status(responseStatus.getStatus())
//                        .message(new ResponseMessage(responseStatus.getMessageType(), name))
//                        .build()
//                );
//    }
//
//    @ExceptionHandler(BetweenServiceException.class)
//    public ResponseEntity<ErrorResponse> betweenServiceException(BetweenServiceException e) {
//        log.error("Between service exception status {}  ", e.getHttpStatus());
//        return ResponseEntity
//                .status(e.getHttpStatus())
//                .body(e.getErrorResponse());
//    }
//
//    @ExceptionHandler(IdGovException.class)
//    public ResponseEntity<ErrorResponse> idGovException(IdGovException e) {
//        log.error("Id gov exception status {}  ", e.getErrorResponse());
//        return ResponseEntity
//                .status(e.getHttpStatus())
//                .body(e.getErrorResponse());
//    }
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex, ServletWebRequest webRequest) {
//        Map<String, String> errors = new HashMap<>();
//        ex.getBindingResult().getAllErrors().forEach((error) -> {
//            String fieldName = ((FieldError) error).getField();
//            String errorMessage = error.getDefaultMessage();
//            errors.put(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, fieldName), errorMessage);
//        });
//        log.error("Validation error {}  ", errors);
//        return ResponseEntity
//                .status(HttpStatus.BAD_REQUEST)
//                .body(errors);
//    }
//
//    @ExceptionHandler(Throwable.class)
//    public ResponseEntity<ErrorResponse> internalServerError(Throwable e) {
//        log.error("Internal server error  ", e);
//        ResponseStatus responseStatus = ResponseStatus.INTERNAL_SERVER_ERROR;
//        String tag = responseStatus.name();
//        TranslationRedis translation = translationRedisService.getByTag(tag);
//        Name name = translation != null ? translation.getName() : new Name(tag, tag, tag, tag);
//        return ResponseEntity
//                .status(responseStatus.getHttpStatus())
//                .body(ErrorResponse.builder()
//                        .status(responseStatus.getStatus())
//                        .message(new ResponseMessage(responseStatus.getMessageType(), name))
//                        .build()
//                );
//    }
//
//}
