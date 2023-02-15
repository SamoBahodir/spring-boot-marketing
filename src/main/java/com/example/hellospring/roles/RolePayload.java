package com.example.hellospring.roles;

import com.example.hellospring.cor.NamePayload;
import com.example.hellospring.cor.Permission;
import com.example.hellospring.cor.Status;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
public class RolePayload extends NamePayload {

    @Size(min = 1)
    @NotNull
    private List<Permission> permissions    ;


    @NotNull
    private Status status;

}
