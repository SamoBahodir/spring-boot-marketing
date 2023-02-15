package com.example.hellospring.token;

import com.example.hellospring.users.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenUserResponse {
    private Long id;
    private String pin;
    private String first_name;
    private String last_name;
    private String middle_name;

    private String photo;

    public TokenUserResponse(User user) {
        this.id = user.getId();
        this.pin = user.getPin();
        this.first_name = user.getFirstName();
        this.last_name = user.getLastName();
        this.middle_name = user.getMiddleName();
    }
}
