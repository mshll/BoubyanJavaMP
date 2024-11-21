package com.bta.accountservice.entity;

import com.bta.accountservice.user.User;
import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

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
    @JoinColumn(name = "user_id")
    private User customerEntity;

    public AccountEntity() {

    }

    public AccountEntity(Long accountNumber, BigDecimal balance, User customerEntity) {
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

    public User getCustomerEntity() {
        return customerEntity;
    }

    public void setCustomerEntity(User customerEntity) {
        this.customerEntity = customerEntity;
    }
}
