package com.mollytea.mollyteawebapp.service;

import org.springframework.stereotype.Component;
import com.mollytea.mollyteawebapp.entity.Address;
import com.mollytea.mollyteawebapp.repository.AddressRepository;

@Component
class JpaAddressService implements AddressService {

    private static final Address EMPTY_ADDRESS = new Address("", "", "");

    private final AddressRepository addressRepository;

    public JpaAddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    @Override
    public Address findOrEmpty(String phone) {
        return this.addressRepository
                .findById(phone)
                .map(entity -> new Address(entity.getAddressLine1(), entity.getAddressLine2(), entity.getPostcode()))
                .orElse(EMPTY_ADDRESS);
    }

    @Override
    public void update(String phone, String addressLine1, String addressLine2, String postcode) {
        Address addressEntity = new Address();
        addressEntity.setPhone(phone);
        addressEntity.setAddressLine1(addressLine1);
        addressEntity.setAddressLine2(addressLine2);
        addressEntity.setPostcode(postcode);

        this.addressRepository.save(addressEntity);
    }
}
