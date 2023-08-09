package dev.nichoko.hibernate.dao;

import java.util.List;

import dev.nichoko.hibernate.entity.Student;

public interface StudentDAO {
    void save(Student student);
    void update(Student student);
    Student findById(int id);
    List<Student> findAll();
    void delete(Integer id);
}
