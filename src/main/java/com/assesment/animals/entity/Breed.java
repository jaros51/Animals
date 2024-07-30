package com.assesment.animals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "breed")
@Getter
@Setter
public class Breed {
    @Id
    private Long id;
    private String name ;
}
