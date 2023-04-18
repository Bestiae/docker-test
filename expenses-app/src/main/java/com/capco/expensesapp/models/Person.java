package com.capco.expensesapp.models;

import lombok.Data;
import javax.persistence.*;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "person")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "full_name", nullable = false)
    private String name;
    private String email;
    private String currency;
    private String country;
    private Integer owe;
    private Integer lent;
}
