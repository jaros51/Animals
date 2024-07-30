package com.assesment.animals.repository;

import com.assesment.animals.entity.Animal;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
}
