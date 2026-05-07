package com.mollytea.mollyteawebapp.dto;

import java.math.BigDecimal;
import java.util.List;

public record OrderResponse(
        Long id,
        BigDecimal totalPrice,
        String status,
        List<OrderItemResponse> items
) {}