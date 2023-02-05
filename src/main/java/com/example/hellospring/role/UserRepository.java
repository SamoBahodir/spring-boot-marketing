package com.example.hellospring.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
//    User findByUsername(String username);

    @Query("select u from User u where u.username=:username")
    User getUserByUsername(@Param("username") String username);

//    boolean existsByUsername(String username);
}
