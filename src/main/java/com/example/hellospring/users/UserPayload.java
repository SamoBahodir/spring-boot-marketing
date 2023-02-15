package com.example.hellospring.users;

import com.example.hellospring.cor.Status;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserPayload  {

    private String userName;


    private String password;

    private String pin;

    private String firstName;

    private String lastName;

    private String middleName;

    private Long roleId;

    private Status status;
}
