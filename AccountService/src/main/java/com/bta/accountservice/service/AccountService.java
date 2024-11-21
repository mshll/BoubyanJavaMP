package com.bta.accountservice.service;

import com.bta.accountservice.bo.AccountResponse;
import com.bta.accountservice.bo.TransferRequest;
import com.bta.accountservice.bo.TransferResponse;
import com.bta.accountservice.entity.AccountEntity;
import com.bta.accountservice.repository.AccountRepository;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.math.BigDecimal;
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
    public AccountEntity getAccountByUserId(Long userId) {
        return accountRepository.findByUserId(userId)
                .orElseThrow(() -> new IllegalArgumentException("Account not found for user ID: " + userId));
    }

    public AccountEntity getAccountByNumber(Long accountNumber) {
        return accountRepository.findById(accountNumber)
                .orElseThrow(() -> new IllegalArgumentException("Account not found for number: " + accountNumber));
    }

    public TransferResponse transferAmount(TransferRequest request, Long userId) {
        try {
            AccountEntity senderAccount = getAccountByUserId(userId);

            if (senderAccount.getBalance().compareTo(request.getAmount()) < 0) {
                return new TransferResponse(null, "Insufficient balance");
            }

            BigDecimal minAmount = new BigDecimal("1.00");
            BigDecimal maxAmount = new BigDecimal("50.00");
            if (request.getAmount().compareTo(minAmount) < 0 || request.getAmount().compareTo(maxAmount) > 0) {
                return new TransferResponse(null, "Transfer amount must be between 1 and 50 KWD");
            }

            AccountEntity recipientAccount = accountRepository.findByAccountNumber(request.getToAccountNumber())
                    .orElseThrow(() -> new IllegalArgumentException("Recipient account not found"));

            senderAccount.setBalance(senderAccount.getBalance().subtract(request.getAmount()));
            recipientAccount.setBalance(recipientAccount.getBalance().add(request.getAmount()));

            accountRepository.save(senderAccount);
            accountRepository.save(recipientAccount);

            return new TransferResponse(
                    String.format("Transfer completed successfully to account: %s", recipientAccount.getAccountNumber()),
                    null
            );
        } catch (IllegalArgumentException e) {
            return new TransferResponse(null, e.getMessage());
        }
    }

    public AccountEntity updateAccountBalance(Long accountNumber, BigDecimal newBalance) {
        AccountEntity account = getAccountByNumber(accountNumber);
        account.setBalance(newBalance);
        return accountRepository.save(account);
    }

}


