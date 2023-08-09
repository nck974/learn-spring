package dev.nichoko.rest.dao.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import dev.nichoko.rest.dao.entity.Employee;
import jakarta.persistence.EntityManager;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public List<Employee> findAll() {
        return entityManager.createQuery("from Employee", Employee.class).getResultList();
    }

    @Override
    public Employee findById(int id) {
        return entityManager.find(Employee.class, id);

    }

    @Override
    public void deleteById(int id) {
        Employee employee = entityManager.find(Employee.class, id);

        if (employee != null) {
            entityManager.remove(employee);
        }

    }

    @Override
    public Employee save(Employee employee) {
        return entityManager.merge(employee);
    }

}
