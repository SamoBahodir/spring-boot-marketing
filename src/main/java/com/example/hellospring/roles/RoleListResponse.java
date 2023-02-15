package com.example.hellospring.roles;

import com.example.hellospring.cor.Name;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class RoleListResponse {
    private Integer id;
    private Name name;
}
