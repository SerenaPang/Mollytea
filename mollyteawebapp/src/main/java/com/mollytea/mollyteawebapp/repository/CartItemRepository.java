package com.mollytea.mollyteawebapp.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.mollytea.mollyteawebapp.entity.CartItem;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    // use userId check cart
    List<CartItem> findByUserId(Long userId);

    // use userId and productId to check
    List<CartItem> findByUserIdAndProductId(Long userId, Long productId);
}
