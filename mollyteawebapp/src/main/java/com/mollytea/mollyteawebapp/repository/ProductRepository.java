package com.mollytea.mollyteawebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mollytea.mollyteawebapp.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
