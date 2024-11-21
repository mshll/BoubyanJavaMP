package com.bta.customerservice.auth;


import com.bta.customerservice.user.Role;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RegisterRequest {

    private String firstName;
    private String lastName;
    private String username;
    private String email;
    private String civilId;
    private String password;
    private String mobileNumber;
    private Role role;

}
