package dev.nichoko.data.jpa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nichoko.data.jpa.dao.EmployeeRepository;
import dev.nichoko.data.jpa.entity.Employee;
import dev.nichoko.data.jpa.exception.EmployeeNotFoundException;
import jakarta.transaction.Transactional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee findById(int id) throws EmployeeNotFoundException {

        Optional<Employee> employee = employeeRepository.findById(id);

        if (!employee.isPresent()) {
            throw new EmployeeNotFoundException("The employee does not exist");
        }

        return employee.get();

    }

    @Override
    @Transactional
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }

    @Override
    @Transactional
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

}
