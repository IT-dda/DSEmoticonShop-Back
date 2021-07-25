package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Emoticon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmoticonRepository extends JpaRepository<Emoticon, Integer> {

    @Query("select e from Emoticon e where e.emoticon_name like %:query%")
    List<Emoticon> search(@Param("query") String query);

}
