package com.assesment.animals.dto;

import lombok.*;

@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class AnimalDto {
    long id;
    String name;
    int age;
    long breedId;
    String gender;
}
