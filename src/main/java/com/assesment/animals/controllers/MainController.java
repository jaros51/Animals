package com.assesment.animals.controllers;


import com.assesment.animals.dto.AnimalDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/")

public class MainController {

    @GetMapping
    public AnimalDto getTestData() {

//        ModelAndView mv = new ModelAndView();
//        mv.setViewName("welcome");
//        mv.getModel().put("data", "Welcome home man");

        AnimalDto one = new AnimalDto();
        one.setId(1);
        one.setName("KOkosko");
        return one;
    }
}
