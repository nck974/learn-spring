package dev.nichoko.rest.dao.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nichoko.rest.dao.dao.EmployeeDAO;
import dev.nichoko.rest.dao.entity.Employee;
import dev.nichoko.rest.dao.exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(int id) throws EmployeeNotFoundException {

        Employee employee = employeeDAO.findById(id);

        if (employee == null) {
            throw new EmployeeNotFoundException("The employee does not exist");
        }

        return employee;

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeDAO.deleteById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeDAO.save(employee);
    }

}
