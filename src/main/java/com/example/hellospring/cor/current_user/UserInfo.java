package com.example.hellospring.cor.current_user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserInfo {
    private Integer id;
    private String usernames;
    private Integer tin;
    private String pin;
    private Integer legalEntityTIN;
    private String first_name;
    private String last_name;
    private String middle_name;
    private String photo;
}