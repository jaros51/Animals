package com.assesment.animals.repository;

import com.assesment.animals.entities.Animal;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {

//    @Query("SELECT a FROM com.assesment.animals.entities.Animal a WHERE " +
//            "a.Gender = com.assesment.animals.entities.Animal.Gender.MALE " +
//            "AND 1=1") // p.name = :name
//    public List<Animal> getAnimals(@Param("id") String id);
//
//    //@Query("SELECT a FROM com.assesment.animals.entities.Animal a where id = 1")
//    Animal getAnimal(@Param("id") String id);

    //@Query("SELECT a FROM com.assesment.animals.entities.Animal a")
    List<Animal> findAll();

    // Find one animal by id
    Animal findById(long id);

//    public List<Animal> getAllAnimals(){
//        return animalRepository.findAll();
//    }

}
