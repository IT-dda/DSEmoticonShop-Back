package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Emoticon;
import com.example.dsemoticonshop.entity.Like;
import com.example.dsemoticonshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Integer> {

    // 좋아요 내역 조회
    @Query("select l from Like l where l.user_id = :user")
    List<Like> getList(@Param("user") User user);

    // 좋아요 있는지 찾기
    @Query("select count(l) from Like l where l.user_id = :user and l.emoticon_id = :emoticon")
    Long findLikeByUser_idAndEmoticon_id(@Param("user") User user, @Param("emoticon") Emoticon emoticon);

    // 좋아요 취소
    @Modifying
    @Query("delete from Like l where l.user_id = :user and l.emoticon_id = :emoticon")
    void dislike(@Param("user") User user, @Param("emoticon") Emoticon emoticon);

}
