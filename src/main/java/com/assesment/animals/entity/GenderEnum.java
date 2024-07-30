package com.assesment.animals.entity;

public enum GenderEnum {
    MALE ("MALE"),
    FEMALE ("FEMALE");

    private final String gender;
    GenderEnum(String gender) {
        this.gender = gender;
    }
    @Override
    public String toString() {
        return gender;
    }
}