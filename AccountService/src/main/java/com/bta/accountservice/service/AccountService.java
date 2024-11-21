package com.bta.accountservice.service;

import com.bta.accountservice.bo.AccountResponse;
import com.bta.accountservice.entity.AccountEntity;
import com.bta.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.util.List;
@Service
public class AccountService {

    private final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountResponse getAccountBalance(Long accountNumber) {
       AccountEntity accountEntity = accountRepository.findById(accountNumber).orElseThrow(() -> new IllegalArgumentException("Account not found"));
        return new AccountResponse(accountEntity.getBalance());

    }


}


