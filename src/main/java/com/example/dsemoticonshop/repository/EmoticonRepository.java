package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Emoticon;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmoticonRepository extends JpaRepository<Emoticon, Integer> {
}
