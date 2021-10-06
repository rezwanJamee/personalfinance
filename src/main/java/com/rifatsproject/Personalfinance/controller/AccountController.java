package com.rifatsproject.Personalfinance.controller;

import com.rifatsproject.Personalfinance.domain.Account;
import com.rifatsproject.Personalfinance.exception.UserInputException;
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
    public Account createAccount(@RequestBody Account account)
            throws UserInputException {
        if(account.getAccountName() != null &&
                account.getBalance() >= 0) {
            return accountService.createAccount(account);
        }else {
            throw new UserInputException("Invaild user input");
        }
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
    public String updateAccount(@RequestBody Account account)
            throws UserInputException{
        if(account.getAccountName() != null &&
                account.getBalance() >= 0 &&
                account.getBankname() != null){
        return accountService.updateAccount(account);
        }else {
            throw new UserInputException("Invaild user input");
        }
    }
    //Transfer money update multiple account balance

    //Delete account
    @DeleteMapping("/{id}")
    public String deleteAccount(@PathVariable Long id){
        return accountService.closeAccount(id);
    }
}
