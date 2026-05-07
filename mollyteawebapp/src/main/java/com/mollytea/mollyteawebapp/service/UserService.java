package com.mollytea.mollyteawebapp.service;

import com.mollytea.mollyteawebapp.dto.UserLoginRequest;
import com.mollytea.mollyteawebapp.dto.UserRegisterRequest;
import com.mollytea.mollyteawebapp.entity.User;

public interface UserService {

    User register(UserRegisterRequest request);
    String login(UserLoginRequest request);
}