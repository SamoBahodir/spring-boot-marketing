package com.example.hellospring.token;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TokenRequest {
    private String username;
    private String password;
}
