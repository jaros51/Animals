package com.assesment.animals.services;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.dto.AnimalWithDetailsDto;
import com.assesment.animals.entity.Animal;
import com.assesment.animals.mapper.AnimalMapper;
import com.assesment.animals.repository.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
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

    public Optional<AnimalDto> getAnimal(Long id){
        return Optional.of(AnimalMapper.INSTANCE.sourceToDestination(animalRepositoryImpl.findById(id).get())); // TODO !!!
    }

    public Animal addAnimal(AnimalDto animalDto){
        Animal animal = AnimalMapper.INSTANCE.destinationToSource(animalDto);
        animal.setId(0L); /// TODO !!! ok ?
        return animalRepositoryImpl.save(animal);
    }

    // update animal
    public Animal updateAnimal(AnimalDto animalDto){
        return animalRepositoryImpl.save(AnimalMapper.INSTANCE.destinationToSource(animalDto));
    }

    // remove animal
    public void removeAnimal(Long id){
        animalRepositoryImpl.deleteById(id);
    }

}
