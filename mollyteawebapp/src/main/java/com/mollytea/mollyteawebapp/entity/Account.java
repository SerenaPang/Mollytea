package com.mollytea.mollyteawebapp.entity;

import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "account")
@Getter @Setter
public class Account {

    @Id
    private String phone;

    @NotBlank
    private String password;

     public Account() {
    }
    public Account(String phone, String password) {
       this.phone = phone;
       this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account that = (Account) o;
        return phone.
    equals(that.phone)
    ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(phone)
    ;
    }

    @Override
    public String toString() {
        return "Account{" +
                "phone=" + phone 
            + '\'' +
                '}';
    }
}