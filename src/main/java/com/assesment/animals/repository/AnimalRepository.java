package com.assesment.animals.repository;

import com.assesment.animals.entity.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import java.math.BigDecimal;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

    @Query(value = "select nextval('animal_seq')", nativeQuery = true)
    BigDecimal getNextValMySequence();
}
