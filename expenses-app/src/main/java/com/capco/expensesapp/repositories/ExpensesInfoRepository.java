package com.capco.expensesapp.repositories;

import com.capco.expensesapp.models.ExpensesInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

@Repository
public interface ExpensesInfoRepository extends JpaRepository<ExpensesInfo, Long> {

    List<ExpensesInfo> findAllByPaid(Long paid);
    List<ExpensesInfo> findAllByAmountBetween(BigDecimal a, BigDecimal b);
}
