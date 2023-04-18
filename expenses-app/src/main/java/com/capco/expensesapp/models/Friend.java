package com.capco.expensesapp.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "friend")
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "friend_one", referencedColumnName = "id")
    private Person friendOne;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "friend_two", referencedColumnName = "id")
    private Person friendTwo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expenses_id", referencedColumnName = "id")
    private Expenses expenses_id;
}