package com.assesment.animals.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AnimalWithDetailsDto {
    long id;
    String name;
    int age;
    String breedName;
    String gender;
}
