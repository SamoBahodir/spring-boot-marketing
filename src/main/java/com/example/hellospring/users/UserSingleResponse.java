package com.example.hellospring.users;

import com.example.hellospring.cor.Permission;
import com.example.hellospring.cor.TechnicalFieldsResponse;
import com.example.hellospring.roles.PermissionResponse;
import com.example.hellospring.roles.RoleListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class UserSingleResponse extends TechnicalFieldsResponse {

    private Long id;

    private String userName;

    private String password;

    private String firstName;

    private String lastName;

    private String middleName;

    private String pin;

    private RoleListResponse role;

    private PermissionResponse permissions;

    public UserSingleResponse(User user) {
        this.setPermissions(new PermissionResponse(Permission.USER_VIEW));
    }

}
