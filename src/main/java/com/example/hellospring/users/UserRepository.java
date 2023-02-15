package com.example.hellospring.users;

import com.example.hellospring.cor.JpaGenericRepository;
import com.example.hellospring.cor.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long>, JpaGenericRepository<User> {
    Optional<User> findByUserNameAndStatus(String username, Status status);

    boolean existsByUserName(String userName);

    User findByUserName(String userName);

    boolean existsByUserNameAndIdNot(String userName, Long id);

}