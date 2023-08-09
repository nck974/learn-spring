package dev.nichoko.rest.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nichoko.rest.entity.Student;
import dev.nichoko.rest.exception.StudentNotFoundException;
import jakarta.annotation.PostConstruct;

@RestController
@RequestMapping("api/v1")
public class StudentRestController {

    private List<Student> students;

    @PostConstruct
    public void initializeStudents() {
        students = new ArrayList<>();

        students.add(new Student("firstName1", "lastName1"));
        students.add(new Student("firstName2", "lastName2"));
        students.add(new Student("firstName3", "lastName3"));
        students.add(new Student("firstName4", "lastName4"));
    }

    @GetMapping("students")
    public List<Student> getStudents() {
        return this.students;
    }

    @GetMapping("students/{studentId}")
    public Student getStudent(@PathVariable int studentId) {

        if (studentId < 0 || studentId >= this.students.size()) {
            throw new StudentNotFoundException("Student id not found: " + studentId);
        }

        return students.get(studentId);
    }

}
