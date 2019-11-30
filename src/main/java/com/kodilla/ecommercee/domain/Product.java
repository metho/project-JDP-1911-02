package com.kodilla.ecommercee.domain;

import javax.persistence.Entity;


import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Product {

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    @NotNull
    private String name;
    @NotNull
    @Column
    private int price;
}
