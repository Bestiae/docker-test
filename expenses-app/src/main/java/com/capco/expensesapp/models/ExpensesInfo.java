package com.capco.expensesapp.models;

import lombok.Data;
import javax.persistence.*;
import java.math.BigDecimal;


@Data
@Entity
@Table(name = "expensesinfo")
public class ExpensesInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "groupvar_id", referencedColumnName = "id")
    private GroupVariety groupvar;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "friend_id", referencedColumnName = "id")
    private Friend friend;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    private Person person;

    private BigDecimal amount;
    private Boolean paid;
    private String currency;
}
