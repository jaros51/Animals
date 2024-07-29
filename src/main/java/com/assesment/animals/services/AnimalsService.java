package com.assesment.animals.services;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.entities.Animal;
import com.assesment.animals.repository.AnimalRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class AnimalsService {

    @Autowired
    private AnimalRepository animalRepositoryImpl;
    // add other repo

//    @Autowired
//    AnimalsService(AnimalRepository animalRepository){
//        this.animalRepository = animalRepository;
//    }


    public List<AnimalDto> getAnimals(){

        List<Animal> animals = animalRepositoryImpl.findAll();
//        System.out.println("getAnimalsAllaa");
//        System.out.println(animals);

        List<AnimalDto> animalDto = AnimalsMapper.INSTANCE.map(animals);
        List animalDtos = new ArrayList<>();
        animalDtos.add(animalDto);

        return animalDtos;
    }


    @Mapper
    public interface AnimalsMapper {
        AnimalsMapper INSTANCE = Mappers.getMapper(AnimalsMapper.class);

        @Mapping(target = "id", source = "source.id")
        AnimalDto sourceToDestination(Animal source);

        List<AnimalDto> map(List<Animal> employees);

        default AnimalDto map(Animal animal) {
            AnimalDto employeeInfoDTO = new AnimalDto();
            employeeInfoDTO.setName(animal.getName());
            /// TODO !!

            return employeeInfoDTO;
        }
    }
}
