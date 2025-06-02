package com.example.service;

import com.example.entity.employee;
import com.example.repository.employeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class employeeServiceImpl implements employeeService{
    private employeeRepository emplyeeRepo;

    @Autowired
    public employeeServiceImpl(employeeRepository emplyeeRepo) {
        this.emplyeeRepo = emplyeeRepo;
    }

    @Override
    public List<employee> getAll() {
        return emplyeeRepo.findAll();
    }

    @Override
    public employee addEmployee(employee employee) {
        return emplyeeRepo.save(employee);
    }
}
