package com.bta.customerservice.user.service;

import com.bta.customerservice.user.Role;
import com.bta.customerservice.user.User;
import com.bta.customerservice.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;


    public User makeAdmin(Integer id) {

        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));

        user.setRole(Role.ADMIN);

        return userRepository.save(user);

    }

}
