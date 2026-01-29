package com.scaler.splitwise.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
@Setter
@Entity
public class Expense extends BaseModel{
    private Double amount;
    private String description;

    @Enumerated
    private Currency currency;
    @ManyToOne
    private User createdBy;
    @ManyToMany
    private List<User> users = new ArrayList<>();


    @ElementCollection
    private Map<User, Double> paidBy = new HashMap<>();

    @ElementCollection
    private  Map<User, Double> owedBy = new HashMap<>();
}
