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

    @GetMapping("/animals/{id}")
    public AnimalDto getAnimal(@PathVariable String id) {
        return animalsService.getAnimal(Long.parseLong(id)).get();
    }

    @GetMapping("/animals")
    public List<AnimalDto> getAnimals() {
        return animalsService.getAnimals();
    }

    @GetMapping("/animalsWithDetails")
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

    // remove animal
    @DeleteMapping("/removeAnimal/{id}")
    public void removeAnimal(@PathVariable String id) {
        animalsService.removeAnimal(Long.parseLong(id));
    }

////    1. addAnimal - REST metóda na pridanie nového zvieratka, prenosový objekt: AnimalDto
//2. removeAnimal - REST metóda na zmazanie zvieratka, url parameter: id
////    3. getAnimal - REST metóda na načítanie zvieratka, url parameter: id, prenosový objekt: AnimalDto
//4. updateAnimal - REST metóda na uloženie zmien zvieratka, prenosový objekt: AnimalDto
////    5. getAnimals - REST metóda na načítanie všetkých zvieratiek, prenosový objekt: AnimalDto[]
////    6. getAnimalsWithDetails - REST metóda na načítanie všetkých zvieratiek s detailnymi parametrami, prenosový objekt: AnimalWithDetailsDto[]


}
