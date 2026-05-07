package com.mollytea.mollyteawebapp.dto;

import java.math.BigDecimal;

public record ProductCreateRequest(
        String name,
        BigDecimal price,
        Long categoryId
) {}