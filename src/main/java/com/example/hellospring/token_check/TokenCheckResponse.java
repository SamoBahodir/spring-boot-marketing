package com.example.hellospring.token_check;

import lombok.Data;

import java.util.Set;

@Data
public class TokenCheckResponse {
    private String user_name;
    private TokenCheckUserResponse user_info;
    private Long exp;
    private Set<String> authorities;
    private String client_id;
}
