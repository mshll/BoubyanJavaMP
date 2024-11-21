package com.bta.accountservice.bo;

import jakarta.validation.constraints.*;

import java.math.BigDecimal;

public class TransferRequest {


    @Size(min = 5, max = 5, message = "Account number must be exactly 5 characters")
    private Long toAccountNumber;

    @DecimalMin(value = "1.0", message = "Amount must be at least 1 KWD")
    @DecimalMax(value = "50.0", message = "Amount must not exceed 50 KWD")
    private BigDecimal amount;

    public TransferRequest(Long toAccountNumber, BigDecimal amount) {
        this.toAccountNumber = toAccountNumber;
        this.amount = amount;
    }

    public @Size(min = 5, max = 5, message = "Account number must be exactly 5 characters") Long getToAccountNumber() {
        return toAccountNumber;
    }

    public void setToAccountNumber(@Size(min = 5, max = 5, message = "Account number must be exactly 5 characters") Long toAccountNumber) {
        this.toAccountNumber = toAccountNumber;
    }

    public @DecimalMin(value = "1.0", message = "Amount must be at least 1 KWD") @DecimalMax(value = "50.0", message = "Amount must not exceed 50 KWD") BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(@DecimalMin(value = "1.0", message = "Amount must be at least 1 KWD") @DecimalMax(value = "50.0", message = "Amount must not exceed 50 KWD") BigDecimal amount) {
        this.amount = amount;
    }
}