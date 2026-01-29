package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class GroupExpense extends BaseModel {
    @ManyToOne
    private Group group;

    @OneToOne
    private Expense expense;

}
