package com.example.hellospring.cor;

import lombok.Data;

@Data
public class SuccessfulResponse<T> {
    private Integer status;
    private ResponseMessage message;
    private T data;


    public SuccessfulResponse(T data) {
        this.data = data;
        this.status = 0;
    }

    public SuccessfulResponse() {
        this.status = 0;
    }
}
