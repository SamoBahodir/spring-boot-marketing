package com.example.hellospring.cor.current_user;

import com.example.hellospring.cor.Permission;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class DecodedDetails {
    private UserInfo user_info;
    private String access_token;
    private String refresh_token;
    private Integer expires_in;
    private List<Permission> authorities;
}