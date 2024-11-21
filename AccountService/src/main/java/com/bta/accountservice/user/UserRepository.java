package com.bta.accountservice.user;

import com.bta.accountservice.entity.AccountEntity;
import com.bta.customerservice.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {

    Optional<User> findByEmail(String email);
    Optional<AccountEntity> findByUserId(Long userId);

//    List<User> findByRole(Role role);

}
