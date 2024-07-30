package com.assesment.animals;

import com.assesment.animals.controller.AnimalController;
import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.entity.Animal;
import com.assesment.animals.entity.Breed;
import com.assesment.animals.entity.GenderEnum;
import com.assesment.animals.services.AnimalsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.List;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = AnimalController.class)
@ExtendWith(MockitoExtension.class)
public class AnimalControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    private AnimalsService animalsService;

    @Autowired
    private ObjectMapper objectMapper;

    private Animal animal;
    private AnimalDto animalDto;

    @BeforeEach
    public void init () {
        animal = new Animal(1L,"Dunčo",5,new Breed(1L,"Afganský chrt"),GenderEnum.MALE);
        animalDto = new AnimalDto(1L,"Dunčo",5,1L,GenderEnum.MALE.toString());


    }


    @Test
    public void AnimalController_FindAnimalById() throws Exception {
        // Define the employee ID for the test
        long animalId = 1;

        // Mocking the service behavior to return an Optional containing a specific Employee instance
        when(animalsService.getAnimal(animalId)).thenReturn(animalDto);

        // Performing an HTTP GET request to retrieve an employee by ID
        ResultActions response = mockMvc.perform(get("/getAnimal/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(animal)));

        // Asserting the response expectations
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(animalDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender", CoreMatchers.is(animalDto.getGender())));
    }

    @Test
    public void AnimalController_FindAllAnimals() throws Exception {
        // Mocking the service behavior to return a list of Employee instances
        when(animalsService.getAnimals()).thenReturn(List.of(animalDto));

        // Performing an HTTP GET request to retrieve all employees
        ResultActions response = mockMvc.perform(get("/getAnimals")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(animal)));

        // Asserting the response expectations
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].name", CoreMatchers.is(animalDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$[0].gender", CoreMatchers.is(animalDto.getGender())));

    }
}