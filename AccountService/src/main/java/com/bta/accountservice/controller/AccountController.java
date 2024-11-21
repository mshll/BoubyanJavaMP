package com.bta.accountservice.controller;

import com.bta.accountservice.bo.AccountResponse;
import com.bta.accountservice.bo.TransferRequest;
import com.bta.accountservice.bo.TransferResponse;
import com.bta.accountservice.entity.AccountEntity;
import com.bta.accountservice.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/")
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/account//balance")
    public ResponseEntity<AccountResponse> getAccountBalance(@RequestParam Long accountNumber) {
        return ResponseEntity.ok(accountService.getAccountBalance(accountNumber));
    }

    @PostMapping("/transfer")
    public ResponseEntity<TransferResponse> transferAmount( @RequestBody TransferRequest transferRequest,
            @RequestHeader("user_id") Long userId) {
        TransferResponse response = accountService.transferAmount(transferRequest, userId);

        if (response.getError() != null) {
            return ResponseEntity.badRequest().body(response);
        }
        return ResponseEntity.ok(response);
    }

}
