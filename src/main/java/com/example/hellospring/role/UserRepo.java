package com.example.hellospring.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);
    boolean existsByUserName(String userName);
}
