package com.assesment.animals.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity(name = "animal")

@Data
public class Animal {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private Integer age;
    @ManyToOne
    @JoinColumn(name="breed_id", nullable=false)
    private Breed breed;
    private String gender;

//    public enum Gender {
//        MALE ("MALE"),
//        FEMALE ("FEMALE");
//        private final String gender;
//        Gender(String gender) {
//            this.gender = gender;
//        }
//        @Override
//        public String toString() {
//            return gender;
//        }
//    }
}

