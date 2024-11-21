package com.bta.accountservice.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class AccountEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="account_number")
    private Long accountNumber;

    @Column(precision = 10, scale = 2) //Decimal(10, 2)
    private BigDecimal balance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id")
    //dont forget to change it to be customer entity
    private AccountEntity customerEntity;

    public AccountEntity(Long accountNumber, BigDecimal balance, AccountEntity customerEntity) {
        this.accountNumber = accountNumber;
        this.balance = new BigDecimal("50.00");
        this.customerEntity = customerEntity;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public AccountEntity getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(AccountEntity customerEntity) {
        this.customerEntity = customerEntity;
    }
}
