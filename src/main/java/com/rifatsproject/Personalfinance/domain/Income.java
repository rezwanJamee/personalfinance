package com.rifatsproject.Personalfinance.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "income")
public class Income {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;
    private String sourceName;
    private float amount;
    private LocalDate createdate;
    private String bankname;

    public Income() {
    }

    public Income(Long incomeId, String sourceName, float amount, LocalDate createdate, String bankname) {
        this.incomeId = incomeId;
        this.sourceName = sourceName;
        this.amount = amount;
        this.createdate = createdate;
        this.bankname = bankname;
    }

    public Long getIncomeId() {
        return incomeId;
    }

    public void setIncomeId(Long incomeId) {
        this.incomeId = incomeId;
    }

    public String getSourceName() {
        return sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public LocalDate getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDate createdate) {
        this.createdate = createdate;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
}
