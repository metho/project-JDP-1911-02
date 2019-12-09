package com.kodilla.ecommercee.domain;

import com.kodilla.ecommercee.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class OrderEntity {

    @Id
    @NotNull
    @GeneratedValue
    private long id;

    @GeneratedValue
    @NotNull
    private int orderNumber;

    private String productGroup;
    private int price;

    @OneToMany(
            targetEntity = Product.class,
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    @JoinColumn(name = "PRODUCT_ID")
    private List<Product> productList = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "Users")
    private User user;


}