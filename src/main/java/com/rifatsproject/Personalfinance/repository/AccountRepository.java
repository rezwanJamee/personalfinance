package com.rifatsproject.Personalfinance.repository;

import com.rifatsproject.Personalfinance.domain.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
