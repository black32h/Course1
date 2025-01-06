package com.example.course1;

import org.springframework.data.jpa.repository.JpaRepository;

// Інтерфейс для роботи з базою даних через JPA
public interface CourseRepository extends JpaRepository<Course, Long> {
    // JpaRepository вже надає всі необхідні методи для CRUD операцій (створення, читання, оновлення, видалення)
    // Якщо потрібно, можна додавати додаткові методи для специфічних запитів.
}
