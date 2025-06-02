package com.example.service;

import com.example.entity.department;

import java.util.List;
import java.util.Optional;

public interface departmentService {
    public Optional<department> getById(int id);
    public List<department> getAll();
    public department addDepartment(department de);
    public void deleteDepartment(int id);
    public department updateDepartment(department de);
}
