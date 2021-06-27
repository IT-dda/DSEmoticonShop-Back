package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
