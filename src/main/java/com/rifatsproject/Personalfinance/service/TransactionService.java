package com.rifatsproject.Personalfinance.service;

import com.rifatsproject.Personalfinance.domain.Account;
import com.rifatsproject.Personalfinance.domain.Transactions;
import com.rifatsproject.Personalfinance.exception.UserInputException;
import com.rifatsproject.Personalfinance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;
    @Autowired
    private AccountService accountService;


    public Transactions createTransaction(Transactions transaction)
            throws UserInputException {

        String name = transaction.getAccountName();
        Account account = accountService.getAccountByName(name);
        if(account != null){
            float currentbalance = account.getBalance() - transaction.getAmount();
            if(currentbalance < 0){
                throw new UserInputException("Operation unsuccessful");
            }
            account.setBalance(currentbalance);
            accountService.updateAccount(account);
            return transactionRepository.save(transaction);
        }else {
            throw new UserInputException("Operation unsuccessful");
        }
    }

    public List<Transactions> getAllTransactions(){
        return transactionRepository.findAll();
    }

    public Transactions getTransactionById(Long id){
        return transactionRepository.findById(id).get();
    }

    //update
    public String updateTransaction(Transactions transaction){
        if(true){
            transactionRepository.save(transaction);
            return "successful";
        }else {
            return "unsuccessful";
        }
    }

    //delete
    public String deleteTransaction(Long id) throws UserInputException{
        Transactions t = transactionRepository.findById(id).get();
        if(t.getTransactionName() != null){
            String message = "Your transaction is deleted!";
            transactionRepository.deleteById(id);
            return message;
        }else {
            throw new UserInputException("Operation unsuccessful");
        }
    }

    public float getMonthlyTransactions(){
        int i = LocalDate.now().getMonthValue();
        return transactionRepository.totalTransactionByMonth(i);
    }
}
