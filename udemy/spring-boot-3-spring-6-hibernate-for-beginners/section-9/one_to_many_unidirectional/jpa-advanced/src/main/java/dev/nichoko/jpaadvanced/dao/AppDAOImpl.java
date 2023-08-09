package dev.nichoko.jpaadvanced.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.nichoko.jpaadvanced.entity.Course;
import dev.nichoko.jpaadvanced.entity.Instructor;
import dev.nichoko.jpaadvanced.entity.InstructorDetail;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
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
    public Course findCourseById(int id) {
        return entityManager.find(Course.class, id);

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

        if (instructor == null) {
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

        if (instructorDetail == null) {
            throw new RuntimeException("id not found");
        }

        instructorDetail.getInstructor().setInstructorDetail(null);

        entityManager.remove(instructorDetail);
    }

    @Override
    public List<Course> findCoursesForInstructorId(int id) {

        TypedQuery<Course> query = entityManager
                .createQuery("from Course where instructor.id = :param", Course.class);
        query.setParameter("param", id);

        return query.getResultList();
    }

    @Override
    public Instructor findInstructorWithCoursesById(int id) {

        TypedQuery<Instructor> query = entityManager
                .createQuery("select i from Instructor i JOIN FETCH i.courses where i.id = :param",
                        Instructor.class);
        query.setParameter("param", id);

        return query.getSingleResult();
    }

    @Override
    @Transactional
    public void update(Instructor instructor) {
        entityManager.merge(instructor);

    }

    @Override
    @Transactional
    public void update(Course course) {
        entityManager.merge(course);

    }

    @Override
    @Transactional // Transactional makes not necessary to switch to EAGER
    public void deleteInstructorById(int id) {
        Instructor instructor = entityManager.find(Instructor.class, id);

        List<Course> courses = instructor.getCourses();
        for (Course course : courses) {
            course.setInstructor(null);
        }

        entityManager.remove(instructor);
    }

    @Override
    @Transactional // Transactional makes not necessary to switch to EAGER
    public void deleteCourseById(int id) {
        Course course = entityManager.find(Course.class, id);

        entityManager.remove(course);
    }

    @Override
    @Transactional
    public void save(Course course) {
        entityManager.persist(course);

    }

    @Override
    public Course findCourseAndReviewsByCourseId(int id) {

        TypedQuery<Course> query = entityManager
                .createQuery("select c from Course c JOIN FETCH c.reviews where c.id = :param",
                        Course.class);
        query.setParameter("param", id);

        return query.getSingleResult();
    }

}
