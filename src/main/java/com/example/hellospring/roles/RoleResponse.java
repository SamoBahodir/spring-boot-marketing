package com.example.hellospring.roles;

import com.example.hellospring.cor.Name;
import com.example.hellospring.cor.Permission;
import com.example.hellospring.cor.TechnicalFieldsResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@EqualsAndHashCode(callSuper = true)
@Data
public class RoleResponse extends TechnicalFieldsResponse {

    private Integer id;

    private Name name;

    private List<PermissionResponse> permissions;

    public RoleResponse (Role role){
        this.id= role.getId();
        this.name=role.getName();
        List<Permission> permissions=role.getPermissions();
        Permission[] myArray=new Permission[permissions.size()];
        permissions.toArray(myArray);
        this.permissions= Arrays.stream(myArray).map(PermissionResponse::new).collect(Collectors.toList());
        this.createdAt=role.getCreatedAt();
        this.updatedAt=role.getUpdatedAt();
        this.status=role.getStatus();
        this.createdBy=null;
        this.updatedBy=null;
    }
}
