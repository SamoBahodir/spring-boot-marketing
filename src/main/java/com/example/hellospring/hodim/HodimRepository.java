package com.example.hellospring.hodim;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HodimRepository extends JpaRepository<Hodim, Long> {
    List<Hodim> findByName(String name);
    List<Hodim> findByNameAndLastName(String name,String lastName);

}
