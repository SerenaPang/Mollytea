package com.mollytea.mollyteawebapp.dto;

public record CartItemResponse(
        Long productId,
        String productName,
        Integer quantity,
        BigDecimal price
) {}