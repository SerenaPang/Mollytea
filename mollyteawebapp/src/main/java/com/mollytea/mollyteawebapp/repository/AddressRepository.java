package com.mollytea.mollyteawebapp.repository;

import org.springframework.data.repository.CrudRepository;
import com.mollytea.mollyteawebapp.entity.Address;

public interface AddressRepository extends CrudRepository<Address, String> {
}
