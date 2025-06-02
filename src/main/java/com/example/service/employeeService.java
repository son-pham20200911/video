package com.example.service;

import com.example.entity.employee;

import java.util.List;

public interface employeeService {
    public List<employee> getAll();
    public employee addEmployee(employee employee);
}
