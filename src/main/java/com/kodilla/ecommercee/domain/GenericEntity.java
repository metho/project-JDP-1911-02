<<<<<<< HEAD:src/main/java/com/kodilla/ecommercee/entity/GenericEntity.java
package com.kodilla.ecommercee.entity;
=======
package com.kodilla.ecommercee.domain;
>>>>>>> 3cba27154beeb784ee7f4678d8e1cb95fb80e2a7:src/main/java/com/kodilla/ecommercee/domain/GenericEntity.java

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String value;

    public GenericEntity() {
    }

    public String getValue() {
        return value;
    }

    public Long getId() {

        return id;
    }

    public GenericEntity(String value) {

        this.value = value;
    }
}
