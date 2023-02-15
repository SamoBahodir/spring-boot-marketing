package com.example.hellospring.users;

import com.example.hellospring.cor.Permission;
import com.example.hellospring.cor.TechnicalFieldsResponse;
import com.example.hellospring.roles.PermissionResponse;
import com.example.hellospring.roles.RoleListResponse;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserUpdatePasswordResponse extends TechnicalFieldsResponse {

    private Long id;

    private String userName;

    private String firstName;

    private String lastName;

    private String middleName;

    private String pin;

    private RoleListResponse role;

    private PermissionResponse permission;


    public UserUpdatePasswordResponse(UserEntity userEntity) {
        this.id = userEntity.getId();
        this.userName = userEntity.getUserName();
        this.firstName = userEntity.getFirstName();
        this.lastName = userEntity.getLastName();
        this.middleName = userEntity.getMiddleName();
        this.pin = userEntity.getPin();
        this.role = new RoleListResponse(userEntity.getRoleId(), userEntity.getRole().getName());
        this.permission = new PermissionResponse(Permission.USER_VIEW);
        this.createdAt = userEntity.getCreatedAt();
        this.updatedAt = userEntity.getUpdatedAt();
        this.status = userEntity.getStatus();

    }
}