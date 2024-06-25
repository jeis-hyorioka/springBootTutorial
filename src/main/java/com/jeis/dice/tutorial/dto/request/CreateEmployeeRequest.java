package com.jeis.dice.tutorial.dto.request;

public record CreateEmployeeRequest(String username, String password, String email, String role) {
}