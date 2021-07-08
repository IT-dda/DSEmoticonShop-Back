package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Like;
import com.example.dsemoticonshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    // 좋아요 내역 조회
    @Query("select l from Like l where l.user_id = :user")
    List<Like> getList(@Param("user")User user);

}
