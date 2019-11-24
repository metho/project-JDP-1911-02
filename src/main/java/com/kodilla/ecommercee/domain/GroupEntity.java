package com.kodilla.ecommercee.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

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

}
