package com.assesment.animals.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "animal")

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Animal {

    @Id
    private Long id;
    private String name;
    private Integer age;

    @ManyToOne
    @JoinColumn(name="breed_id", nullable=false)
    private Breed breed;

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    private Gender gender;

    public enum Gender {
        MALE ("MALE"),
        FEMALE ("FEMALE");
        private final String gender;
        Gender(String gender) {
            this.gender = gender;
        }
        @Override
        public String toString() {
            return gender;
        }
    }
}

