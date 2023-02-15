package com.example.hellospring.users;

import com.example.hellospring.cor.TechnicalFieldsResponse;
import com.example.hellospring.roles.RoleListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserListResponse extends TechnicalFieldsResponse {
    private Long id;

    private String fullName;

    private String pin;

    private RoleListResponse role;

    private String userName;

    private String password;


    public UserListResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.pin = userEntity.getPin();
        this.fullName = userEntity.getFullName();
        this.userName = userEntity.getUserName();
        this.password = userEntity.getPassword();
    }
}
