package com.example.hellospring.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {
    User findByUserName(String userName);

    @Query("select u from User u where u.userName=:userName")
    User findByLogin(@Param("userName") String userName);

    boolean existsByUserName(String userName);
}
