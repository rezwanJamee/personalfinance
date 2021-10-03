package com.rifatsproject.Personalfinance.controller;

import com.rifatsproject.Personalfinance.domain.Transactions;
import com.rifatsproject.Personalfinance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/transactions")
@CrossOrigin("*")
public class TransactionController {

    @Autowired
    private TransactionService transactionService;

    @PostMapping
    public Transactions addTransaction(@RequestBody Transactions transaction){
        return transactionService.createTransaction(transaction);
    }

    @GetMapping
    public List<Transactions> getAllTransactions(){
        return transactionService.getAllTransactions();
    }

    @GetMapping("/{id}")
    public Transactions getTransactionById(@PathVariable Long id){
        return transactionService.getTransactionById(id);
    }

    @PutMapping
    public String updateTransaction(@RequestBody Transactions transaction){
        return transactionService.updateTransaction(transaction);
    }

    @DeleteMapping("/{id}")
    public String deleteTransaction(@PathVariable Long id){
        return transactionService.deleteTransaction(id);
    }
}
