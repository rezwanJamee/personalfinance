package com.rifatsproject.Personalfinance.service;

import com.google.gson.JsonObject;
import com.rifatsproject.Personalfinance.domain.Account;
import com.rifatsproject.Personalfinance.domain.Income;
import com.rifatsproject.Personalfinance.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

@Service
@Transactional
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;
    @Autowired
    private AccountService accountService;

    public List<Income> getAllIncome(){
        return incomeRepository.findAll();
    }

    public Income getSingleIncome(Long id){
        return incomeRepository.findById(id).get();
    }

    public String createIncome(Income income){

        String name = income.getBankname();
        Account a = accountService.getAccountByName(name);
        if(a != null){
            float currentbalance = a.getBalance() + income.getAmount();
            a.setBalance(currentbalance);
            accountService.updateAccount(a);
            incomeRepository.save(income);
            return "Created successfully!";
        }else {
            return "Operation unsuccessfully!";
        }
    }

    public String updateIncome(Income income){
        incomeRepository.save(income);
        return "Updated successfully!";
    }

    public String deleteIncome(Long id){
        incomeRepository.deleteById(id);
        return "Deleted successfully!";
    }

    public float totalIncome(){
        return incomeRepository.totalEarning();
    }

    public float totalIncomeByMonth(){
        int i = LocalDate.now().getMonthValue();

        JsonObject message = new JsonObject();
        float a = incomeRepository.totalEarningByMonth(i);
        String str = String.valueOf(a);
        message.addProperty("balance", str);
        //System.out.println(message);

        return incomeRepository.totalEarningByMonth(i);
    }
}
