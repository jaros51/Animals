package com.assesment.animals.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Entity(name = "animal")
@Getter
@Setter
public class Animal {

    @Id
    private Long id;
    private String name;
    private Integer age;

    @ManyToOne
    @JoinColumn(name="breed_id", nullable=false)
    private Breed breed;
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

