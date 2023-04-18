package com.capco.expensesapp.repositories;

import com.capco.expensesapp.models.Expenses;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface ExpensesRepository extends JpaRepository<Expenses, Long> {

    List<Expenses> findAllByPayer_Id(Long id);

    List<Expenses> findAllByType(String type);

    @Modifying
    @Query(value = "DELETE FROM Expenses e WHERE e.Id = ?1", nativeQuery = true)
    void deleteExpensesById(Long id);

    //test
    List<Expenses> findAllByCategory(String category);
    //bad
//    List<Expenses> findExpensesByCategory(String category);
}
