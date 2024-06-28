package com.pesto.tech.taskManagement.repository;

import com.pesto.tech.taskManagement.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {

    @Query(value = "SELECT * FROM User WHERE userName =:name")
    User loadUserByUsername(String name);
}
