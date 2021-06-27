package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GiftRepository extends JpaRepository<Gift, Integer> {
}
