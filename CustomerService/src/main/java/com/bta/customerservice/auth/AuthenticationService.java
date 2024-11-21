package com.bta.customerservice.auth;

import com.bta.customerservice.config.JwtService;
import com.bta.customerservice.user.Role;
import com.bta.customerservice.user.Status;
import com.bta.customerservice.user.User;
import com.bta.customerservice.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;


    public AuthenticationRegisterResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .username(request.getUsername())
                .email(request.getEmail())
                .civilId(request.getCivilId())
                .mobileNumber(request.getMobileNumber())
                .password(passwordEncoder.encode(request.getPassword()))
                .accountStatus(Status.active)
                .role(request.getRole())
                .sessionIdTime(new Date())
                .build();
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationRegisterResponse.builder()
                .message("Customer onboarded successfully")
                .customerId(user.getId())
                .accountNumber("")  // TODO
                .balance(50L)   // TODO
                .token(jwtToken)
                .build();
    }

    public AuthenticationLoginResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()
                )
        );
        var user = repository.findByEmail(request.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationLoginResponse.builder()
                .fistName(user.getFirstName())
                .lastName(user.getLastName())
                .civilId(user.getCivilId())
                .mobileNumber(user.getMobileNumber())
                .accountNumber("")  // TODO
                .token(jwtToken)
                .build();

    }

}
