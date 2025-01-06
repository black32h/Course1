package com.example.course1;

import org.springframework.stereotype.Service;

@Service // Оголошуємо клас як сервіс, щоб він був керований Spring контейнером
public class CourseService {

    private final CourseRepository courseRepository;

    // Конструктор для ін'єкції залежностей
    public CourseService(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }

    // Метод для створення нового курсу
    public Course createCourse(Course course) {
        // Зберігаємо курс у базі даних
        return courseRepository.save(course);
    }

    // Метод для отримання курсу за його id
    public Course getCourseById(Long id) {
        // Повертаємо курс за допомогою репозиторію або викидаємо помилку, якщо не знайдено
        return courseRepository.findById(id).orElseThrow(() -> new RuntimeException("Course not found"));
    }

    // Метод для оновлення інформації про курс
    public Course updateCourse(Long id, Course course) {
        // Отримуємо існуючий курс за id
        Course existingCourse = getCourseById(id);
        
        // Оновлюємо поля курсу
        existingCourse.setName(course.getName());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setInstructor(course.getInstructor());
        
        // Зберігаємо оновлений курс
        return courseRepository.save(existingCourse);
    }

    // Метод для видалення курсу за id
    public void deleteCourse(Long id) {
        // Видаляємо курс за допомогою репозиторію
        courseRepository.deleteById(id);
    }
}
