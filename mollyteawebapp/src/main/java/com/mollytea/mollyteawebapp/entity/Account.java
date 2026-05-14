package com.mollytea.mollyteawebapp.entity;
 
import lombok.Getter;
import lombok.Setter;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;
 
@Entity
@Table(name = "account")
@Getter
@Setter
public class Account {
 
    @Id
    @Column(length = 20)
    private String phone;
 
    @NotBlank
    private String password;
 
    // 由数据库 AUTO_INCREMENT 生成，Java 只读不写
    @Column(name = "user_id", unique = true, insertable = false, updatable = false)
    private Long userId;
 
    public Account() {
    }
 
    public Account(String phone, String password) {
        this.phone = phone;
        this.password = password;
    }
 
    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Account that = (Account) o;
        return phone.equals(that.phone);
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(phone);
    }
 
    @Override
    public String toString() {
        return "Account{" +
                "phone=" + phone + '\'' +
                ", userId=" + userId +
                '}';
    }
}