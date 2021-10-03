package com.rifatsproject.Personalfinance.repository;

import com.rifatsproject.Personalfinance.domain.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IncomeRepository extends JpaRepository<Income, Long> {

     @Query(value = "SELECT SUM(amount) FROM income", nativeQuery = true)
     float totalEarning();

    @Query(value = "SELECT SUM(amount) FROM income WHERE MONTH(createdate) = ?", nativeQuery = true)
    float totalEarningByMonth(int i);
}
