package com.example.hellospring.roles;

import com.example.hellospring.cor.Permission;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
public class PermissionResponse {

    private String name;

    private String title;

    public PermissionResponse(Permission permission) {
        this.name = permission.name();
        this.title = permission.getTitle();
    }

}
