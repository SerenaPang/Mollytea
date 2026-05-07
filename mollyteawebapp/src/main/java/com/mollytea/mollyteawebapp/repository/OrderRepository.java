package com.mollytea.mollyteawebapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mollytea.mollyteawebapp.entity.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {
    // check all history order
    List<Order> findHistoryOrderByUserId(Long userId);

    // check order by status：PAID / CREATED）
    List<Order> findByStatus(String status);
}