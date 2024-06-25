package com.jeis.dice.tutorial.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.jeis.dice.tutorial.dto.request.CreateEmployeeRequest;
import com.jeis.dice.tutorial.entity.Employee;
import com.jeis.dice.tutorial.service.EmployeeService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private EmployeeService mockService;

    @Test
    public void getEmployeeTest() throws Exception {
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setUsername("mockname2");
        employee.setEmail("test2@example.com");
        employee.setPassword("testpass2");
        employee.setRole("testrole2");
        when(mockService.findEmployee(any())).thenReturn(employee);
        this.mockMvc.perform(get("/employees/get/2"))
                .andExpect(status().isOk());
    }

    @Test
    @DisplayName("従業員リストを取得")
    public void getEmployeeListTest() throws Exception {
        List<Employee> employeeList = new ArrayList<>();
        when(mockService.getEmployees()).thenReturn(employeeList);
        this.mockMvc.perform(get("/employees")).andExpect(status().isOk());
    }

    @Test
    @DisplayName("従業員作成")
    public void saveEmployeeTest() throws Exception {
        CreateEmployeeRequest request = new CreateEmployeeRequest("johndoe", "password", "john@example.com", "USER");
        Employee employee = new Employee();
        employee.setId(1L);
        employee.setUsername("johndoe");
        employee.setEmail("john@example.com");
        employee.setPassword("password");
        employee.setRole("USER");

        mockMvc.perform(MockMvcRequestBuilders.post("/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"username\":\"johndoe\",\"password\":\"password\",\"email\":\"john@example.com\",\"role\":\"USER\"}"))
                .andExpect(status().isOk());

    }
}