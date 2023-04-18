package com.capco.expensesapp.models;

import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;


@Data
@Entity
@Table(name = "groupvariety")
public class GroupVariety {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    private String groupvar_name;

    @CreationTimestamp
    private LocalDateTime create_date;

    private Boolean expenses_done;
}
