package com.example.course1;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import org.springframework.data.annotation.Id;

@Entity
public class Course {

    @jakarta.persistence.Id  // Визначаємо первинний ключ для сутності Course
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Автоматичне генерування значення первинного ключа
    private Long id;

    private String name;  // Назва курсу
    private String description;  // Опис курсу
    private String instructor; // Ім'я викладача

    // Геттер для id
    public Long getId() {
        return id;
    }

    // Сеттер для id
    public void setId(Long id) {
        this.id = id;
    }

    // Геттер для name
    public String getName() {
        return name;
    }

    // Сеттер для name
    public void setName(String name) {
        this.name = name;
    }

    // Геттер для description
    public String getDescription() {
        return description;
    }

    // Сеттер для description
    public void setDescription(String description) {
        this.description = description;
    }

    // Геттер для instructor
    public String getInstructor() {
        return instructor;
    }

    // Сеттер для instructor
    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
}
