package com.mollytea.mollyteawebapp.auth;

public interface SignupService {
    boolean accountExists(String phone);
    void register(String phone, String password, String addressLine1, String addressLine2, String postcode);
}
