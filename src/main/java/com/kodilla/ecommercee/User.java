package com.kodilla.ecommercee;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue
    @Column(unique = true)
    private Long id;

    @Column
    private String firstname;

    @Column
    private String lastname;

    @Column
    private String address;

    @Column
    private Integer postcode;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "Cart_id")
    private Cart cart;

    @OneToMany (
            targetEntity = UserOrder.class,
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER
    )
    private List<UserOrder> order = new ArrayList<>();


}
