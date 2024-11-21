package com.bta.customerservice.auth;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.processing.Pattern;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationLoginResponse {
    private String fistName;
    private String lastName;
    private String civilId;
    private String mobileNumber;
    private String accountNumber;
    private String token;
}
