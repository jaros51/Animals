package com.assesment.animals.controller;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.dto.AnimalWithDetailsDto;
import com.assesment.animals.entity.Animal;
import com.assesment.animals.services.AnimalsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping(value = "/")

public class AnimalController {

    @Autowired
    AnimalsService animalsService;

    @GetMapping("/getAnimal/{id}")
    public ResponseEntity getAnimal(@PathVariable String id) {
        AnimalDto animal;
        try {
            animal = animalsService.getAnimal(Long.parseLong(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(animal);
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
    public ResponseEntity addAnimal(@RequestBody AnimalDto animalDto) {
        Animal animal;
        try {
            animal = animalsService.addAnimal(animalDto);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(animal);
    }

    @PutMapping("/updateAnimal")
    public ResponseEntity updateAnimal(@RequestBody AnimalDto animalDto) {
        Animal animal;
        try {
            animal = animalsService.updateAnimal(animalDto);
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(animal);
    }

    @DeleteMapping("/removeAnimal/{id}")
    public ResponseEntity removeAnimal(@PathVariable String id) {
        try {
            animalsService.removeAnimal(Long.parseLong(id));
        }catch (Exception e){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(e.getMessage());
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Animal with id " + id + " removed successfully !");
    }

}
