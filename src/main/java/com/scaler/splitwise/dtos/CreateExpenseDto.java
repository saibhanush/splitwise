package com.scaler.splitwise.dtos;

import com.scaler.splitwise.models.Currency;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Getter
@Setter
@AllArgsConstructor
public class CreateExpenseDto {
    private String description;
    private Double amount;

    private Currency currency;

    private Long createdBy;

    private List<Long> users = new ArrayList<>();

    private Map<Long, Long> paidBy = new HashMap<>();

    private Map<Long, Long> owedBy = new HashMap<>();
}
