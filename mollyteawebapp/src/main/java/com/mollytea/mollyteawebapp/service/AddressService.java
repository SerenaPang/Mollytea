package com.mollytea.mollyteawebapp.service;

import com.mollytea.mollyteawebapp.entity.Address;

public interface AddressService {
    Address findOrEmpty(String phone);
    void update(String phone, String addressLine1, String addressLine2, String postcode);
}
