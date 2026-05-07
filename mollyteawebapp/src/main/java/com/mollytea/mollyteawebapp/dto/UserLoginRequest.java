package com.mollytea.mollyteawebapp.dto;

public record UserLoginRequest(
        String phone,
        String password
) {}