package dev.nichoko.security.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.nichoko.security.dao.EmployeeRepository;
import dev.nichoko.security.entity.Employee;
import dev.nichoko.security.exception.EmployeeNotFoundException;
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
