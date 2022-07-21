package com.example.hellospring.role;

import com.example.hellospring.enurmation.Status;
import com.sun.istack.NotNull;
import lombok.Data;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name = "user_role_spring")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    private String userName;
    private String password;
    private String email;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Status status;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role",
            joinColumns = {@JoinColumn(name = "user_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "role_name", referencedColumnName = "name")}
    )
    private Set<Rol> roles = new HashSet<>();
}
