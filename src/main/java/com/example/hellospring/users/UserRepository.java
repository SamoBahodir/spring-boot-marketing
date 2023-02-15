package com.example.hellospring.users;

import com.example.hellospring.cor.JpaGenericRepository;
import com.example.hellospring.cor.Status;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long>, JpaGenericRepository<UserEntity> {
    Optional<UserEntity> findByUserNameAndStatus(String username, Status status);

    boolean existsByUserName(String userName);

    boolean existsByUserNameAndIdNot(String userName, Long id);
}
