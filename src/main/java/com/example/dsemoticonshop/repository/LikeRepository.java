package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Like;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    @Query("select l.emoticon_id from Like l where l.user_id = :id")
    List<Integer> findByUser_id(@Param("id") String user_id);
    // 받은 emoticon_id list를 다시 검색해서 emoticon 전달

}