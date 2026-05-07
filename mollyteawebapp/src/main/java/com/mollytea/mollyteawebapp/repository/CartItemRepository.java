package com.mollytea.mollyteawebapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mollytea.mollyteawebapp.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    List<CartItem> findByCartId(Long cartId);
}