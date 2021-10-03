package com.rifatsproject.Personalfinance.controller;

import com.rifatsproject.Personalfinance.domain.Account;
import com.rifatsproject.Personalfinance.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/accounts")
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    @GetMapping("/{id}")
    public Account getSingleAccounts(@PathVariable Long id){
        return accountService.findAccountById(id);
    }

    //update account balance
    @PutMapping
    public String updateAccount(@RequestBody Account account){
        return accountService.updateAccount(account);
    }
    //Transfer money update multiple account balance

    //Delete account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id){
        return accountService.closeAccount(id);
    }

}
