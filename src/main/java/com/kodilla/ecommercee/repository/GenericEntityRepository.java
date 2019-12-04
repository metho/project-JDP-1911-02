<<<<<<< HEAD:src/main/java/com/kodilla/ecommercee/entity/GenericEntityRepository.java
package com.kodilla.ecommercee.entity;
=======
package com.kodilla.ecommercee.repository;
>>>>>>> 3cba27154beeb784ee7f4678d8e1cb95fb80e2a7:src/main/java/com/kodilla/ecommercee/repository/GenericEntityRepository.java

import com.kodilla.ecommercee.domain.GenericEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenericEntityRepository extends JpaRepository<GenericEntity, Long> { }
