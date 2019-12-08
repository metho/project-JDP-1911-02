package com.kodilla.ecommercee;

import com.kodilla.ecommercee.domain.Cart;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
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

    public User(String username, String password, String address, Integer postcode) {
        this.username = username;
        this.password = password;
        this.address = address;
        this.postcode = postcode;
    }

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