package dev.nichoko.jpaadvanced.dao;

import dev.nichoko.jpaadvanced.entity.Instructor;
import dev.nichoko.jpaadvanced.entity.InstructorDetail;

public interface AppDAO {
    void save(Instructor instructor);
    void removeById(int id);
    Instructor findInstructorById(int id);
    InstructorDetail findInstructorDetailById(int id);
    void removeInstructorDetailById(int id);
}
