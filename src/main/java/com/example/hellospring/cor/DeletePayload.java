package com.example.hellospring.cor;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class DeletePayload {
    @NotBlank
    private String message;
}
