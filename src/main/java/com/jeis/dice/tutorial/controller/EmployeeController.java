package com.jeis.dice.tutorial.controller;

import com.jeis.dice.tutorial.dto.request.CreateEmployeeRequest;
import com.jeis.dice.tutorial.entity.Employee;
import com.jeis.dice.tutorial.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
@CrossOrigin(origins = "http://localhost:5173")
public class EmployeeController {

    @Autowired
    EmployeeService service;

    @GetMapping("/get/{id}")
    public Employee getEmployee(@PathVariable("id") Long id) {
        System.out.println("Checking ID: " + id);
        return service.findEmployee(id);
    }

    @GetMapping("")
    public List<Employee> getEmployees() {
        return service.getEmployees();
    }

    @PostMapping("")
    public Employee saveEmployee(@RequestBody CreateEmployeeRequest body) {
        return service.saveEmployee(body);
    }
}