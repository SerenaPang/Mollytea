package com.mollytea.mollyteawebapp.dto;

public record AddToCartRequest(
        Long productId,
        Integer quantity
) {}