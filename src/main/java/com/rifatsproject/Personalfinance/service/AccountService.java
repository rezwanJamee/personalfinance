package com.rifatsproject.Personalfinance.service;

import com.rifatsproject.Personalfinance.domain.Account;
import com.rifatsproject.Personalfinance.repository.AccountRepository;
import org.apache.juli.logging.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account findAccountById(Long Id){
        return accountRepository.findById(Id).get();
    }


    public String updateAccount(Account account){
        if(account.getBalance() != 0){
            accountRepository.save(account);
            return "Updated successfully";
        }else {
            return "Update unsuccessful";
        }
    }

    public String closeAccount(Long id){
        String message = "Your account " + findAccountById(id).getAccountName()
                +" with balance " + findAccountById(id).getBalance() +" is closed!";
        accountRepository.deleteById(id);
        return message;
    }
}
