package com.example.hellospring.role;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
@Data
@Entity
public class Rol {
    @Id
    private String name;
}
