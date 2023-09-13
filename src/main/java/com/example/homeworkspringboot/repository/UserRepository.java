package com.example.homeworkspringboot.repository;

import com.example.homeworkspringboot.dto.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
