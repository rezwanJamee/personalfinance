package com.rifatsproject.Personalfinance.service;

import com.rifatsproject.Personalfinance.domain.Transactions;
import com.rifatsproject.Personalfinance.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TransactionService {

    @Autowired
    private TransactionRepository transactionRepository;


    public Transactions createTransaction(Transactions transaction){
        return transactionRepository.save(transaction);
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
    public String deleteTransaction(Long id){
        String message = "Your transaction is deleted!";
        transactionRepository.deleteById(id);
        return message;
    }

    public float getMonthlyTransactions(){
        int i = LocalDate.now().getMonthValue();
        return transactionRepository.totalTransactionByMonth(i);
    }
}
