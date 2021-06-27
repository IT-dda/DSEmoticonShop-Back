package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
