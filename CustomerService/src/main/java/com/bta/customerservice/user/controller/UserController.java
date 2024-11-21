package com.bta.customerservice.user.controller;

import com.bta.customerservice.user.User;
import com.bta.customerservice.user.UserRepository;
import com.bta.customerservice.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserRepository userRepository;
    private final UserService userService;

    @GetMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userRepository.findAll(); // Fetches all users from database
        return ResponseEntity.ok(users); // Return the list of users
    }

    @PutMapping("/{id}/make-admin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<String> makeUserAdmin(@PathVariable Integer id) {
        userService.makeAdmin(id);
        return ResponseEntity.ok("User has been promoted to admin");
    }


}
