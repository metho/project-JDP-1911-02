package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashMap;
import java.util.Map;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Group")
public class GroupEntity {

    @Id
    @NotNull
    @GeneratedValue (strategy= GenerationType.AUTO)
    @Column(name = "id")
    private long id;

    @Column (name="productGroup")
    private Map<Product, Integer> products  = new HashMap<>();
}
