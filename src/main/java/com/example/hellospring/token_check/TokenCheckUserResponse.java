package com.example.hellospring.token_check;

import lombok.Data;

@Data
public class TokenCheckUserResponse {
    private Integer id;
    private String pin;
    private String first_name;
    private String last_name;
    private String middle_name;
}
