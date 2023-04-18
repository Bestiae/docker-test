package com.capco.expensesapp.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GroupVarietyDTO {
    private Long Id;
    private String groupvar_name;
    private LocalDateTime create_date;
    private Boolean expenses_done;
}