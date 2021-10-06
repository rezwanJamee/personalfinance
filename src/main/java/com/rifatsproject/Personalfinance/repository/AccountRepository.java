package com.rifatsproject.Personalfinance.repository;

import com.rifatsproject.Personalfinance.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {

    @Query(value = "SELECT * FROM accounts WHERE account_name = ?", nativeQuery = true)
    Account getAccountDetails(String name);

//    @Query(value = "SELECT account_name FROM accounts", nativeQuery = true)
//    List<Account> getAllAccountNamesOnly();
}
