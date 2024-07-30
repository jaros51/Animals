package com.assesment.animals.services;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.dto.AnimalWithDetailsDto;
import com.assesment.animals.entity.Animal;
import com.assesment.animals.mapper.AnimalMapper;
import com.assesment.animals.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AnimalsService {

    @Autowired
    private AnimalRepository animalRepositoryImpl;

    public List<AnimalDto> getAnimals(){
        return AnimalMapper.INSTANCE.toDTOList(animalRepositoryImpl.findAll());
    }

    public List<AnimalWithDetailsDto> getAnimalsWithDetails(){
        return AnimalMapper.INSTANCE.toDTOListWithDetails(animalRepositoryImpl.findAll());
    }

    public AnimalDto getAnimal(Long id){
        Optional<Animal> animal = animalRepositoryImpl.findById(id);
        if(animal.isEmpty()){
            throw new IllegalArgumentException("Animal with id " + id + " does not exist !");
        }
        return animal.map(AnimalMapper.INSTANCE::sourceToDestination).get();
    }

    public Animal addAnimal(AnimalDto animalDto){
        Animal animal = AnimalMapper.INSTANCE.destinationToSource(animalDto);
        if(animalDto.getId() < 1){
            BigDecimal next = animalRepositoryImpl.getNextValMySequence();
            animal.setId(next.longValue());
        }

        boolean exists = animalRepositoryImpl.existsById(animal.getId());
        if(exists){
            throw new IllegalArgumentException("Id already exists !");
        }

        return animalRepositoryImpl.save(animal);
    }

    public Animal updateAnimal(AnimalDto animalDto){

        boolean exists = animalRepositoryImpl.existsById(animalDto.getId());
        if(!exists){
            throw new IllegalArgumentException("Id does not exist !");
        }

        return animalRepositoryImpl.save(AnimalMapper.INSTANCE.destinationToSource(animalDto));
    }

    public void removeAnimal(Long id){
        boolean exists = animalRepositoryImpl.existsById(id);
        if(!exists){
            throw new IllegalArgumentException("Id does not exist !");
        }
        animalRepositoryImpl.deleteById(id);
    }

}
