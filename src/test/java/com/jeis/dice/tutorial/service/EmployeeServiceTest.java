package com.jeis.dice.tutorial.service;

import com.jeis.dice.tutorial.dto.request.CreateEmployeeRequest;
import com.jeis.dice.tutorial.entity.Employee;
import com.jeis.dice.tutorial.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@SpringBootTest
public class EmployeeServiceTest {

    @Autowired
    EmployeeService service;

    @Nested
    class TestSave {
        @Autowired
        EmployeeService service;

        @MockBean
        EmployeeRepository mockRepository;

        @Test
        void testSave() {
            String username = "mockname2";
            String email = "test2@example.com";
            String password = "testpass2";
            String role = "role";

            Employee employee = new Employee();
            employee.setUsername(username);
            employee.setEmail(email);
            employee.setPassword(password);
            employee.setRole(role);
            when(mockRepository.save(any())).thenReturn(employee);

            CreateEmployeeRequest request = new CreateEmployeeRequest(username, password, email, role);
            Employee result = service.saveEmployee(request);
            Assertions.assertEquals(result, employee);
        }
    }


    @Test
    void testGetEmployeeList() {
        var list = service.getEmployees();
        Assertions.assertEquals(2, list.size());
    }
}