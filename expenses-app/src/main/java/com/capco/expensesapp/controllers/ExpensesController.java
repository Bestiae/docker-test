package com.capco.expensesapp.controllers;

import com.capco.expensesapp.dtos.ExpensesDTO;
import com.capco.expensesapp.models.Expenses;
import com.capco.expensesapp.services.ExpensesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("expenses")
public class ExpensesController {

    @Autowired
    private final ExpensesService expensesService;

    public ExpensesController(ExpensesService expensesService) {
        this.expensesService = expensesService;
    }

    @GetMapping("/all")
    public List<ExpensesDTO> getAllExpenses() {
        log.info("List of all expenses -> expensesService.getAllExpenses();");
        return expensesService.getAllExpenses();
    }

    @GetMapping("/find-payer/{id}")
    public List<ExpensesDTO> findExpensesByPayerId(@PathVariable(value = "id") Long id) {
        log.info("expensesService.findExpensesByPayerId({});", id);
        return expensesService.findExpensesByPayerId(id);
    }

    @GetMapping("/find-category/{category}")
    public List<ExpensesDTO> findExpensesByCategory(@PathVariable(value = "category") String category) {
        log.info("expensesService.findExpensesByCategory({}});", category);
        return expensesService.findExpensesByCategory(category);
    }

    @GetMapping("/find-splitType/{splitType}")
    public List<ExpensesDTO> findExpensesBySplitType(@PathVariable(value = "splitType") String splitType) {
        log.info("expensesService.findExpensesBySplitType({}});", splitType);
        return expensesService.findExpensesBySplitType(splitType);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteExpensesById(@PathVariable(value = "id")
                                       @Min(value = 0, message = "Friends id must be more then 0") Long id) {
        log.info("expensesService.deleteExpensesById({});", id);
        expensesService.deleteExpensesById(id);
    }

    @PostMapping(path = "/add", consumes = "application/json", produces = "application/json")
    public ExpensesDTO addExpenses(@RequestBody @Valid ExpensesDTO expenses) {
        log.info("expensesService.addExpenses({});", expenses);
        return expensesService.addExpenses(expenses);
    }

    @PutMapping("/update/{id}")
    public ExpensesDTO updateExpenses(@RequestBody ExpensesDTO expenses, @PathVariable("id") Long id) {
        log.info("");
        return expensesService.updateExpensesById(id, expenses);
    }
}