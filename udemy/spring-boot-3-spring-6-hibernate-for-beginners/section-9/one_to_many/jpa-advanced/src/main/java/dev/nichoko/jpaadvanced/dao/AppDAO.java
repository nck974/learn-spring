package dev.nichoko.jpaadvanced.dao;

import java.util.List;

import dev.nichoko.jpaadvanced.entity.Course;
import dev.nichoko.jpaadvanced.entity.Instructor;
import dev.nichoko.jpaadvanced.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    void removeById(int id);
    Instructor findInstructorById(int id);
    Course findCourseById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void removeInstructorDetailById(int id);
    List<Course> findCoursesForInstructorId(int id);
    Instructor findInstructorWithCoursesById(int id);
    void update(Instructor instructor);
    void update(Course course);
    void deleteInstructorById(int id);
    void deleteCourseById(int id);
}
