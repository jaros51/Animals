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
        //animalsService = Mockito.mock(AnimalsService.class);

        List<AnimalDto> x = animalsService.getAnimals();

        System.out.println("TESTING");
        System.out.println(x);

        assert(x != null);
        assert(x.size() == 4);
    }

}
