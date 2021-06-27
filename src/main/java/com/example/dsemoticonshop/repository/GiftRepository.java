package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Gift;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GiftRepository extends JpaRepository<Gift, Integer> {

    // 보낸 선물 조회
    @Query("select g from Gift g where g.from_id = :id")
    List<Gift> findByFrom_id(@Param("id") String id);

    // 받은 선물 조회
    @Query("select g from Gift g where g.to_id = :id")
    List<Gift> findByTo_id(@Param("id") String id);

}