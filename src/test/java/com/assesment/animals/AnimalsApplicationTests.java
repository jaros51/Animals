package com.assesment.animals;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.services.AnimalsService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.List;

@SpringBootTest
class AnimalsApplicationTests {

    @Autowired
    AnimalsService animalsService;

    @Test
    void testGetAnimals() {

        List<AnimalDto> animals = animalsService.getAnimals();
        assert(animals != null);
        assert(animals.size() == 4);

        animalsService.removeAnimal(0L);
        animalsService.removeAnimal(1L);
        animals = animalsService.getAnimals();

        assert(animals != null);
        assert(animals.size() == 3);

        animalsService.addAnimal(new AnimalDto(1L, "Dunčo", 5, 1L, "MALE"));
        animals = animalsService.getAnimals();

        assert(animals != null);
        assert(animals.size() == 4);
    }

    @Test
    void testGetAnimal() {

        AnimalDto animal = animalsService.getAnimal(2L).get();

        assert(animal != null);
        assert(animal.getAge() == 7);
        assert(animal.getBreedId() == 1);
        assert(animal.getGender().equals("FEMALE"));
    }

}
