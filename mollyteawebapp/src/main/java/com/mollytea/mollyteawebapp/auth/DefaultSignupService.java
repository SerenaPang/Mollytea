package com.mollytea.mollyteawebapp.auth;


import org.springframework.stereotype.Component;

import com.mollytea.mollyteawebapp.service.AccountService;
import com.mollytea.mollyteawebapp.service.AddressService;

import jakarta.transaction.Transactional;

@Component
class DefaultSignupService implements SignupService {

    private final AccountService accountService;
    private final AddressService addressService;

    public DefaultSignupService(AccountService accountService, AddressService addressService) {
        this.accountService = accountService;
        this.addressService = addressService;
    }

    @Override
    public boolean accountExists(String phone) {
        return false;
    }

    @Override
    @Transactional
    public void register(String phone, String password, String addressLine1, String addressLine2, String postcode) {
        this.accountService.register(phone, password);
        this.addressService.update(phone, addressLine1, addressLine2, postcode);
    }
}
