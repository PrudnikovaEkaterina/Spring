package org.example.spring.models;

import jakarta.validation.constraints.*;

public class Person {
    private int id;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @NotBlank
    private String name;
    @NotEmpty(message = "Name should not be empty")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters")
    @NotBlank
    private String surname;
    @NotEmpty(message = "Name should not be empty")
    @NotBlank
    @Email
    private String email;
    @Positive(message = "Age must be positive")
    private int age;

    public Person(int id, String name, String surname, String email, int age) {
        this.id = id;
        this.name = name;
        this.surname=surname;
        this.email=email;
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person() {}

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
