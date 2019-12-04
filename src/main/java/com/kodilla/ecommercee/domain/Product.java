<<<<<<< HEAD
//Utworzenie tej klasy było mi potrzebne do stworzenia metod dodawania i usuwania produktu z koszyka
package com.kodilla.ecommercee.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue
    @Column
    private Long id;
=======
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
>>>>>>> 3cba27154beeb784ee7f4678d8e1cb95fb80e2a7
}
