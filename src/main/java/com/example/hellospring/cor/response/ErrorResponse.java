package com.example.hellospring.cor.response;

import com.example.hellospring.cor.ResponseMessage;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private Integer status;
    private ResponseMessage message;
}
