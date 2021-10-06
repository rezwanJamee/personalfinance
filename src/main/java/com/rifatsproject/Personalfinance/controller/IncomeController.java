package com.rifatsproject.Personalfinance.controller;

import com.rifatsproject.Personalfinance.domain.Income;
import com.rifatsproject.Personalfinance.service.IncomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/incomes")
@CrossOrigin("*")
public class IncomeController {

    @Autowired
    private IncomeService incomeService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addIncome(@RequestBody Income income){
        return incomeService.createIncome(income);
    }

    @GetMapping
    public List<Income> getAllIncomes(){
        return incomeService.getAllIncome();
    }

    @GetMapping("/{id}")
    public Income getOneIncome(@PathVariable Long id){
        return incomeService.getSingleIncome(id);
    }

    @PutMapping
    public String updateIncome(@RequestBody Income income){
        return incomeService.updateIncome(income);
    }

    @DeleteMapping("/{id}")
    public String deleteOneIncome(@PathVariable Long id){
        return incomeService.deleteIncome(id);
    }

    @GetMapping("/total")
    public float getTotalIncomes(){
        return incomeService.totalIncome();
    }

    @GetMapping("/totalBymonth")
    public float getTotalIncomesByMonth(){
        return incomeService.totalIncomeByMonth();
    }
}
