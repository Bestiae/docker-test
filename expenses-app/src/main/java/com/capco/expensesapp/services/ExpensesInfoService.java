package com.capco.expensesapp.services;

import com.capco.expensesapp.exception.NotFoundException;
import com.capco.expensesapp.models.ExpensesInfo;
import com.capco.expensesapp.repositories.ExpensesInfoRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Slf4j
@Service
public class ExpensesInfoService {

    private final ExpensesInfoRepository expensesInfoRepository;

    @Autowired
    public ExpensesInfoService(ExpensesInfoRepository expensesInfoRepository) {
        this.expensesInfoRepository = expensesInfoRepository;
    }

    public List<ExpensesInfo> getAllExpensesInfo() {
        log.info("expensesInfoRepository.findAll()");
        return expensesInfoRepository.findAll();
    }

    public ExpensesInfo getExpensesInfoById(Long id) {
        log.info("expensesInfoRepository.findById({})", id);
        return expensesInfoRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("ExpensesInfo with Id = " +
                        id + " is not found."));
    }

    public List<ExpensesInfo> getAllExpensesInfoByPaid(Long paid) {
        log.info("expensesInfoRepository.findAllByPaid({});", paid);
        return expensesInfoRepository.findAllByPaid(paid);
    }

    public List<ExpensesInfo> getAllExpensesInfoAmountBetween(BigDecimal lower, BigDecimal higher) {
        log.info("expensesInfoRepository.findAllByAmountBetween({}, {});", lower, higher);
        return expensesInfoRepository.findAllByAmountBetween(lower, higher);
    }

//    public ExpensesInfo
}