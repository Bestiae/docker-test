package com.capco.expensesapp.models;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "expenses")
public class Expenses {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payer_id", referencedColumnName = "id")
    private Person payer;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "expenses_id", referencedColumnName = "id")
    private Friend expenses;

    @Column(name = "split_type", nullable = false)
    private String type;
    private String comment;
    private String category;
    private LocalDateTime create_date;
    private BigDecimal amount;
    private String currency;
}
