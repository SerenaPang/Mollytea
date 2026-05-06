package com.mollytea.mollyteawebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mollytea.mollyteawebapp.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}