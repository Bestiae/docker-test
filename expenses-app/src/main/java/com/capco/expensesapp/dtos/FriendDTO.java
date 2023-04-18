package com.capco.expensesapp.dtos;

import com.capco.expensesapp.models.Expenses;
import com.capco.expensesapp.models.Person;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FriendDTO {

    private Long Id;
    private Person friendOne;
    private Person friendTwo;
    private Expenses expenses_id;
}
