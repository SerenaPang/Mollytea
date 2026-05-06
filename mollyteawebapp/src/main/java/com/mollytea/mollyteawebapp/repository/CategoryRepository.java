package com.mollytea.mollyteawebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mollytea.mollyteawebapp.entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {}