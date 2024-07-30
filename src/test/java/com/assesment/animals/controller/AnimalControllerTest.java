package com.assesment.animals.controller;

import com.assesment.animals.dto.AnimalDto;
import com.assesment.animals.entity.Animal;
import com.assesment.animals.entity.Breed;
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
import java.util.Optional;

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
        animal = new Animal(
                1L,
                "Dunčo",
                5,
                new Breed(
                        1L,
                        "Afganský chrt"
                ),
                "MALE"
        );

        animalDto = new AnimalDto(
                1L,
                "Dunčo",
                5,
                1L,
                "MALE"
        );
    }


    @Test
    public void AnimalController_FindAnimalById() throws Exception {
        // Define the employee ID for the test
        long animalId = 1;

        // Mocking the service behavior to return an Optional containing a specific Employee instance
        when(animalsService.getAnimal(animalId)).thenReturn(Optional.of(animalDto));

        // Performing an HTTP GET request to retrieve an employee by ID
        ResultActions response = mockMvc.perform(get("/getAnimal/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(animal)));

        // Asserting the response expectations
        response.andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.name", CoreMatchers.is(animalDto.getName())))
                .andExpect(MockMvcResultMatchers.jsonPath("$.gender", CoreMatchers.is(animalDto.getGender())));
    }


}