package com.example.hellospring.roles;

import com.example.hellospring.cor.JpaGenericRepository;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Integer>, JpaGenericRepository<Role> {



}
