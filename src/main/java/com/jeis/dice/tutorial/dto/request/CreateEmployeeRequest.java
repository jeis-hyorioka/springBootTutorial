package com.jeis.dice.tutorial.dto.request;

import jakarta.validation.constraints.NotNull;

public record CreateEmployeeRequest(String username, String password, String email, String role) {
}