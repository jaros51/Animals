package com.assesment.animals.mapper;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.dto.AnimalWithDetailsDto;
import com.assesment.animals.entity.Animal;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import java.util.List;

@Mapper
public interface AnimalMapper {
    AnimalMapper INSTANCE = Mappers.getMapper(AnimalMapper.class);

    @Mapping(target = "breedId", source = "breed.id")
    AnimalDto sourceToDestination(Animal source);

    @Mapping(target = "breed.id", source = "breedId")
    Animal destinationToSource(AnimalDto destination);

    @Mapping(target = "breedName", source = "breed.name")
    AnimalWithDetailsDto sourceToDestinationWithDetails(Animal source);

    @Mapping(target = "breedId", source = "breed.id")
    List<AnimalDto> toDTOList(List<Animal> animals);

    @Mapping(target = "breedName", source = "breed.name")
    List<AnimalWithDetailsDto> toDTOListWithDetails(List<Animal> animals);

}
