package com.jeis.dice.tutorial.repository;

import com.jeis.dice.tutorial.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}