package com.example.course1;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/courses")  // Визначаємо базовий URL для роботи з курсами
public class CourseController {
    private final CourseService courseService;  // Всі операції з курсами обробляються через CourseService

    // Конструктор для впровадження залежності CourseService
    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    // Метод для створення нового курсу
    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course) {
        // Створюємо курс і повертаємо статус 200 (OK) з об'єктом курсу
        return ResponseEntity.ok(courseService.createCourse(course));
    }

    // Метод для отримання курсу за ID
    @GetMapping("/{id}")
    public ResponseEntity<Course> getCourse(@PathVariable Long id) {
        // Повертаємо курс за вказаним ID
        return ResponseEntity.ok(courseService.getCourseById(id));
    }

    // Метод для оновлення даних курсу
    @PutMapping("/{id}")
    public ResponseEntity<Course> updateCourse(@PathVariable Long id, @RequestBody Course course) {
        // Оновлюємо курс за вказаним ID і повертаємо статус 200 (OK)
        return ResponseEntity.ok(courseService.updateCourse(id, course));
    }

    // Метод для видалення курсу за ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCourse(@PathVariable Long id) {
        // Видаляємо курс за вказаним ID та повертаємо статус без контенту
        courseService.deleteCourse(id);
        return ResponseEntity.noContent().build();
    }
}
