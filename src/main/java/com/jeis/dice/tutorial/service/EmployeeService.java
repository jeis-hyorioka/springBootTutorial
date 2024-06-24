package com.jeis.dice.tutorial.service;

import com.jeis.dice.tutorial.dto.request.CreateEmployeeRequest;
import com.jeis.dice.tutorial.entity.Employee;
import com.jeis.dice.tutorial.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository repository;

    public Employee saveEmployee(CreateEmployeeRequest body) {
        Employee employee = new Employee();
        employee.setUsername(body.username());
        employee.setPassword(body.password());
        employee.setEmail(body.email());
        employee.setRole(body.role());
        return repository.save(employee);
    }

    public Employee findEmployee(Long id){
        return repository.findById(id).orElseThrow();
    }

    public List<Employee> getEmployees() {
        return repository.findAll();
    }
}
