package com.assesment.animals.controller;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.dto.AnimalWithDetailsDto;
import com.assesment.animals.entity.Animal;
import com.assesment.animals.services.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/")

public class MainController {

    @Autowired
    AnimalsService animalsService;

    @GetMapping("/getAnimal/{id}")
    public AnimalDto getAnimal(@PathVariable String id) {
        return animalsService.getAnimal(Long.parseLong(id)).get(); // ?
    }

    @GetMapping("/getAnimals")
    public List<AnimalDto> getAnimals() {
        return animalsService.getAnimals();
    }

    @GetMapping("/getAnimalsWithDetails")
    public List<AnimalWithDetailsDto> getAnimalsWithDetails() {
        return animalsService.getAnimalsWithDetails();
    }

    @PostMapping("/addAnimal")
    public Animal addAnimal(@RequestBody AnimalDto animalDto) {
        if( animalDto.getId() > 0) {
            throw new IllegalArgumentException("Id must be 0 for new animal");
        }
        return animalsService.addAnimal(animalDto);
    }

    @PutMapping("/updateAnimal")
    public Animal updateAnimal(@RequestBody AnimalDto animalDto) {
        return animalsService.updateAnimal(animalDto);
    }

    @DeleteMapping("/removeAnimal/{id}")
    public void removeAnimal(@PathVariable String id) {
        animalsService.removeAnimal(Long.parseLong(id));
    }

}
