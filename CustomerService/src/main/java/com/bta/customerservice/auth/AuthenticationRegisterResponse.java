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
public class AuthenticationRegisterResponse {

    private String message;
    private Long customerId;
    private String accountNumber;
    private Long balance;
    private String token;
}
