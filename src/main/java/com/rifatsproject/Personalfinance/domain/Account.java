package com.rifatsproject.Personalfinance.domain;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    private String accountName;
    private float balance;
    private LocalDate createdate;
    private LocalDate lastupdate;
    private String bankname;

    public Account() {
    }

    public Account(Long accountId, String accountName, float balance, LocalDate createdate, LocalDate lastupdate, String bankname) {
        this.accountId = accountId;
        this.accountName = accountName;
        this.balance = balance;
        this.createdate = createdate;
        this.lastupdate = lastupdate;
        this.bankname = bankname;
    }

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public LocalDate getCreatedate() {
        return createdate;
    }

    public void setCreatedate(LocalDate createdate) {
        this.createdate = createdate;
    }

    public LocalDate getLastupdate() {
        return lastupdate;
    }

    public void setLastupdate(LocalDate lastupdate) {
        this.lastupdate = lastupdate;
    }

    public String getBankname() {
        return bankname;
    }

    public void setBankname(String bankname) {
        this.bankname = bankname;
    }
}
