package com.example.dsemoticonshop.repository;

import com.example.dsemoticonshop.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
