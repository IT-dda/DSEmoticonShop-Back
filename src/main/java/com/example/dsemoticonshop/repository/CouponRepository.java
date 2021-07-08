package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Coupon;
import com.example.dsemoticonshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    // 사용 / 미사용 쿠폰 조회
    @Query("select c from Coupon c where c.user_id = :user and c.isUsed = :use")
    List<Coupon> getList(@Param("user")User user, @Param("use") boolean isUsed);

}
