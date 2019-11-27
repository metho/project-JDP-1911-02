//Utworzenie tej klasy było mi potrzebne do stworzenia metod dodawania i usuwania produktu z koszyka
package com.kodilla.ecommercee.domain;

import lombok.Getter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
public class Product {
    @Id
    @GeneratedValue
    @Column
    private Long id;
}
