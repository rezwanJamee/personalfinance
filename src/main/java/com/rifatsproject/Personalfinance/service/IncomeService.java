package com.rifatsproject.Personalfinance.service;

import com.google.gson.JsonObject;
import com.rifatsproject.Personalfinance.domain.Income;
import com.rifatsproject.Personalfinance.repository.IncomeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class IncomeService {

    @Autowired
    private IncomeRepository incomeRepository;

    public List<Income> getAllIncome(){
        return incomeRepository.findAll();
    }

    public Income getSingleIncome(Long id){
        return incomeRepository.findById(id).get();
    }

    public String createIncome(Income income){
        incomeRepository.save(income);
        return "Created successfully!";
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
