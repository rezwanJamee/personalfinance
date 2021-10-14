package com.rifatsproject.Personalfinance.service;

import com.rifatsproject.Personalfinance.domain.Account;
import com.rifatsproject.Personalfinance.exception.UserInputException;
import com.rifatsproject.Personalfinance.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
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

    //Delete account
    public String closeAccount(Long id) throws UserInputException {
        try{
        String message = "Your account " + findAccountById(id).getAccountName()
                +" with balance " + findAccountById(id).getBalance() +" is closed!";
        accountRepository.deleteById(id);
        return message;
        }catch (Exception e){
            throw new UserInputException("Invalid user input");
        }
    }

    //Get account by name
    public Account getAccountByName(String name){
        return accountRepository.getAccountDetails(name);
    }
}
