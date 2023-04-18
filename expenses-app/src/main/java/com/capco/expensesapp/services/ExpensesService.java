package com.capco.expensesapp.services;

import com.capco.expensesapp.dtos.ExpensesDTO;
import com.capco.expensesapp.exception.NotFoundException;
import com.capco.expensesapp.models.Expenses;
import com.capco.expensesapp.repositories.ExpensesRepository;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
public class ExpensesService {

    private final ExpensesRepository expensesRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public ExpensesService(ExpensesRepository expensesRepository, ModelMapper modelMapper) {
        this.expensesRepository = expensesRepository;
        this.modelMapper = modelMapper;
    }

    public List<ExpensesDTO> getAllExpenses() {
        log.info("Find all expenses -> return expensesRepository.findAll();");
        return modelMapper.map(expensesRepository.findAll(), new TypeToken<List<ExpensesDTO>>(){}.getType());
    }

    public List<ExpensesDTO> findExpensesByPayerId(Long id) {
        log.info("expensesRepository.findAllExpensesByPersonId({});", id);
        return modelMapper.map(expensesRepository.findAllByPayer_Id(id),
                new TypeToken<List<ExpensesDTO>>(){}.getType());
    }

    public List<ExpensesDTO> findExpensesByCategory(String category) {
        log.info("expensesRepository.findExpensesByCategory({});", category);
        return modelMapper.map(expensesRepository.findAllByCategory(category),
                new TypeToken<List<ExpensesDTO>>(){}.getType());
    }

    public List<ExpensesDTO> findExpensesBySplitType(String splitType) {
        log.info("expensesRepository.findExpensesBySplit_type({});", splitType);
        return modelMapper.map(expensesRepository.findAllByType(splitType),
                new TypeToken<List<ExpensesDTO>>(){}.getType());
    }

    public void deleteExpensesById(Long id) {
        log.info("groupMemberRepository.findById({})", id);
        Expenses expenses = expensesRepository.findById(id)
                .orElseThrow(() ->
                        new NotFoundException("Expenses is not present in the table with this id: " + id));
        log.info("groupMemberRepository.deleteGroupMemberById({});", expenses.getId());
        expensesRepository.deleteExpensesById(expenses.getId());
    }

    public ExpensesDTO addExpenses(ExpensesDTO expensesDTO) {
        Expenses expenses = modelMapper.map(expensesDTO, Expenses.class);
        log.info("expensesRepository.save({});", expenses);
        return modelMapper.map(expensesRepository.save(expenses), ExpensesDTO.class);
    }

    public ExpensesDTO updateExpensesById(Long id, ExpensesDTO expensesDTO) {
        Expenses expenses = modelMapper.map(expensesDTO, Expenses.class);
        Expenses expensesDB = expensesRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Expenses with id " + id + " is not presented in the table"));

        if (expenses != null) {
            if(Objects.nonNull(expenses.getType()) && !"".equalsIgnoreCase(expenses.getType())){
                expensesDB.setType(expenses.getType());
            }
            if(Objects.nonNull(expenses.getComment()) && !"".equalsIgnoreCase(expenses.getComment())){
                expensesDB.setComment(expenses.getComment());
            }
            if(Objects.nonNull(expenses.getCategory()) && !"".equalsIgnoreCase(expenses.getCategory())){
                expensesDB.setCategory(expenses.getCategory());
            }
            if(Objects.nonNull(expenses.getAmount())){
                expensesDB.setAmount(expenses.getAmount());
            }
            if(Objects.nonNull(expenses.getCurrency()) && !"".equalsIgnoreCase(expenses.getCurrency())){
                expensesDB.setCurrency(expenses.getCurrency());
            }

            return modelMapper.map(expensesRepository.save(expensesDB), ExpensesDTO.class);
        }else {
            return  null;
        }
    }


}
