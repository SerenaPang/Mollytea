package com.mollytea.mollyteawebapp.service;

import com.mollytea.mollyteawebapp.dto.UserLoginRequest;
import com.mollytea.mollyteawebapp.dto.UserRegisterRequest;
import com.mollytea.mollyteawebapp.entity.User;
import com.mollytea.mollyteawebapp.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public User register(UserRegisterRequest request) {

        User user = User.builder()
                .phone(request.phone())
                .name(request.name())
                .password(request.password())
                .build();

        return userRepository.save(user);
    }

    @Override
    public String login(UserLoginRequest request) {

        User user = userRepository.findByPhone(request.phone())
                .orElseThrow(() -> new RuntimeException("User Does Not Exist"));

        if (!user.getPassword().equals(request.password())) {
            throw new RuntimeException("Wrong Password");
        }

        return "LOGIN_SUCCESS";
    }
}