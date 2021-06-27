package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CouponRepository extends JpaRepository<Coupon, Integer> {

    // 사용 / 미사용 쿠폰 조회
    @Query("select c from Coupon c where c.user_id = :id and c.isUsed = :use")
    List<Coupon> findByUser_id (@Param("id") String user_id, @Param("use") Boolean isUsed);

}
