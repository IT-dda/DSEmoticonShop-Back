package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Gift;
import com.example.dsemoticonshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, Integer> {

    // 받은 선물 내역 조회
    @Query("select g from Gift g where g.to_id = :user")
    List<Gift> getReceivedList(@Param("user") User user);

    // 보낸 선물 내역 조회
    @Query("select g from Gift g where g.from_id = :user")
    List<Gift> getSentList(@Param("user") User user);

    // 선물 조회
    @Query("select g from Gift g where g.code = :code")
    Gift findGiftByCode(@Param("code") String code);

    // 받은 선물 등록 - g.to_id == null and g.gift_id == id
    @Modifying
    @Query("update Gift g set g.to_id = :user where g.code = :code")
    void registerGift(@Param("user") User user, @Param("id") String code);

}
