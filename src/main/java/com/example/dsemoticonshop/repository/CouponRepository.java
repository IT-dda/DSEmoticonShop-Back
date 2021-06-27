package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {
}
