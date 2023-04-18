package com.capco.expensesapp.repositories;

import com.capco.expensesapp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findAllByName(String name);

    List<Person> findAllByCountry(String counry);

    @Modifying
    @Query(value = "Delete from Person p Where p.Id = ?1", nativeQuery = true)
    void deletePersonById(Long id);

}
