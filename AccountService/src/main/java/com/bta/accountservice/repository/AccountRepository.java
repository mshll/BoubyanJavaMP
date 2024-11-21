package com.bta.accountservice.repository;

import com.bta.accountservice.entity.AccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<AccountEntity, Long> {
    Optional<AccountEntity> findByUserId(Long userId);
    Optional<AccountEntity> findByAccountNumber(Long accountNumber);

}
