package com.mollytea.mollyteawebapp.dto;

public record UserResponse(
        Long id,
        String phone,
        String name,
        Integer points
) {}