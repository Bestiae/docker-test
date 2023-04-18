package com.capco.expensesapp.repositories;

import com.capco.expensesapp.models.GroupVariety;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupVarietyRepository extends JpaRepository<GroupVariety, Long> {

    @Query(value = "select * from groupvariety g where g.groupvar_name = ?1 ", nativeQuery = true)
    GroupVariety findGroupVarietyByGroupvar_name(String groupName);
}
