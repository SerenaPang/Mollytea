package com.mollytea.mollyteawebapp.dto;

import java.math.BigDecimal;

public record OrderItemResponse(
        String productName,
        Integer quantity,
        BigDecimal price
) {}