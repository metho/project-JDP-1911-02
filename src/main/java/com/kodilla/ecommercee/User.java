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
    private Long id;
    private String username;
    private String password;
    private String address;
    private Integer postcode;

    @OneToOne
    @JoinColumn(name = "cart_id")
    private Cart cart;

    @OneToMany (
            mappedBy = "user",
            cascade = CascadeType.ALL,
            fetch = FetchType.LAZY
    )
    private List<UserOrder> order = new ArrayList<>();
}
