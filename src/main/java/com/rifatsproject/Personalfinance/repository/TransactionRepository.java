package com.rifatsproject.Personalfinance.repository;

import com.rifatsproject.Personalfinance.domain.Transactions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TransactionRepository extends JpaRepository<Transactions, Long> {

    @Query(value = "SELECT SUM(amount) FROM transaction WHERE MONTH(date) = ?", nativeQuery = true)
    float totalTransactionByMonth(int i);
}
