package com.mollytea.mollyteawebapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.mollytea.mollyteawebapp.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}
