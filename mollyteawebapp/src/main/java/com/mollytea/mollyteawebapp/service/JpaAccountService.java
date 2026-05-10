package com.mollytea.mollyteawebapp.service;
import com.mollytea.mollyteawebapp.entity.Account;
import com.mollytea.mollyteawebapp.repository.AccountRepository;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
class JpaAccountService implements AccountService {

    private final AccountRepository accountRepository;
    private final PasswordEncoder passwordEncoder;

    JpaAccountService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void register(String phone, String password) {
        Account account = new Account();
        account.setPhone(phone);
        account.setPassword(passwordEncoder.encode(password));

        this.accountRepository.save(account);
    }

    @Override
    public Account find(String phone) {
        Account account = this.accountRepository.findByPhone(phone);
        return new Account(account.getPhone(), account.getPassword());
    }

    @Override
    public boolean exists(String phone) {
        return this.accountRepository.findByPhone(phone) != null;
    }
}
