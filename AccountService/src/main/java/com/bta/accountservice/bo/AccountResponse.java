package com.bta.accountservice.bo;

import java.math.BigDecimal;

public class AccountResponse {
    private BigDecimal balance;

    public AccountResponse(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBalance() {
        return balance;
    }
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

}
