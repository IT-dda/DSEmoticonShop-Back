package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {

    // 구매 내역 조회
    @Query("select o from Order o where o.purchaser = :id")
    List<Order> findByPurchaser(@Param("id") String user_id);

}