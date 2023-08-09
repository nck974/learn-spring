package dev.nichoko.jpaadvanced.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.nichoko.jpaadvanced.entity.Instructor;
import dev.nichoko.jpaadvanced.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;

@Repository
public class AppDAOImpl implements AppDAO {

    private EntityManager entityManager;

    @Autowired
    public AppDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Instructor findInstructorById(int id) {
        return entityManager.find(Instructor.class, id);

    }

    @Override
    @Transactional
    public void save(Instructor instructor) {
        entityManager.persist(instructor);
    }

    @Override
    @Transactional
    public void removeById(int id) {
        Instructor instructor = this.findInstructorById(id);

        if (instructor == null){
            throw new RuntimeException("id not found");
        }

        entityManager.remove(instructor);
    }

    @Override
    public InstructorDetail findInstructorDetailById(int id) {
        return entityManager.find(InstructorDetail.class, id);
    }

    @Override
    @Transactional
    public void removeInstructorDetailById(int id) {
        InstructorDetail instructorDetail = this.findInstructorDetailById(id);

        if (instructorDetail == null){
            throw new RuntimeException("id not found");
        }

        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);        
    }

    

}
