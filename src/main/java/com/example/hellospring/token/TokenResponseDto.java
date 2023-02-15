package com.example.hellospring.token;

import lombok.Data;

@Data
public class TokenResponseDto {
    private String access_token;
    private String token_type;
    private String refresh_token;
    private Integer expires_in;
}
