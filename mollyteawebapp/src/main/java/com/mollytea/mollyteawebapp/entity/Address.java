package com.mollytea.mollyteawebapp.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity(name = "address")
@Getter
@Setter
public class Address {

    @Id
    @NotBlank
    private String phone
    ;

    @NotBlank
    private String addressLine1;

    private String addressLine2;

    @NotBlank
    private String postcode;
    public Address() {
    }
    public Address(String phone, String addressLine1, String addressLine2) {
        this.phone = phone;
        this.addressLine1 = addressLine1;
        this.addressLine2 = addressLine2;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Address that = (Address) o;
        return phone
        .equals(that.phone

        );
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone

        );
    }

    @Override
    public String toString() {
        return "Address{" +
                "phone="
                 + phone
                 + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                ", postcode='" + postcode + '\'' +
                '}';
    }
}
