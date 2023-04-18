package com.capco.expensesapp.dtos;

import com.capco.expensesapp.models.GroupVariety;
import com.capco.expensesapp.models.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupMemberDTO {

    private Long Id;
    private GroupVariety groupvar;
    private Person person;

}
