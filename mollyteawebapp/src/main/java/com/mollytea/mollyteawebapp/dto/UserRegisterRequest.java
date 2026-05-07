package com.mollytea.mollyteawebapp.dto;

public record UserRegisterRequest(
        String phone,
        String name,
        String password
) {}