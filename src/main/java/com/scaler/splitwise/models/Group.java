package com.scaler.splitwise.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name = "groups")
public class Group extends BaseModel {
    private String name;

    @ManyToMany
    private List<User> admins = new ArrayList<>();
    @ManyToMany
    private List<User> members = new ArrayList<>() ;

    private Date createdAt;
    @ManyToOne
    private User createdBy;
}
