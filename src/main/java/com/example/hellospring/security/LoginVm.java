package com.example.hellospring.security;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class LoginVm {
    private String username;
    private String password;
}
