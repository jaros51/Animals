package com.assesment.animals.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity(name = "breed")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Breed {
    @Id
    private Long id;
    private String name ;
}
