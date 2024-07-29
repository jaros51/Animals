package com.assesment.animals.controller;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.services.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/")

public class MainController {

    @Autowired
    AnimalsService animalsService;

    @GetMapping("/error")
    public AnimalDto getErr() {
        return new AnimalDto();
    }

    @GetMapping("/getAnimal/{id}")
    public AnimalDto getAnimal(@PathVariable(value="1") String id) {

        System.out.println("TESTID"+id);

        AnimalDto one = new AnimalDto();
        one.setId(Integer.parseInt(id));
        one.setName("KOkosko:"+id);
        return one;
    }

    @GetMapping("/getAnimals")
    public List<AnimalDto> getAnimals() {
//
//        AnimalDto one = new AnimalDto();
//        one.setId(1);
//        one.setName("KOkosko");
        return (animalsService.getAnimals()) ;
    }
}
