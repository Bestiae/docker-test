package com.capco.expensesapp.repositories;

import com.capco.expensesapp.models.GroupMember;
import com.capco.expensesapp.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface GroupMemberRepository extends JpaRepository<GroupMember, Long> {

    GroupMember findGroupMemberByPerson(Person person);

    @Modifying
    @Query(value = "DELETE FROM GroupMember g WHERE g.Id = ?1", nativeQuery = true)
    void deleteGroupMemberById(Long id);

}
