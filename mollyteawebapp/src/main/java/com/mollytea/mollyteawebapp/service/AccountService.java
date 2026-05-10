package com.mollytea.mollyteawebapp.service;

import com.mollytea.mollyteawebapp.entity.Account;

public interface AccountService {
    void register(String phone, String password);
    Account find(String phone
    );
    boolean exists(String phone
    );
}
