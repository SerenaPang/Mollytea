package com.mollytea.mollyteawebapp.dto;

import java.math.BigDecimal;

public record ProductResponse(
        Long id,
        String name,
        BigDecimal price,
        Long categoryId
) {}