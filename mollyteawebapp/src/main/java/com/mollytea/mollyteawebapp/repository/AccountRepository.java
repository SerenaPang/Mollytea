package com.mollytea.mollyteawebapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.mollytea.mollyteawebapp.entity.Account;

public interface AccountRepository extends CrudRepository<Account, String> {
    Account findByPhone(String phone);
}
