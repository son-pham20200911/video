package com.example.service;

import com.example.entity.department;
import com.example.repository.departmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class departmentServiceImpl implements departmentService{
    private departmentRepository departRepo;

    @Autowired
    public departmentServiceImpl(departmentRepository departRepo) {
        this.departRepo = departRepo;
    }

    @Override
    public Optional<department> getById(int id) {
        return departRepo.findById(id);
    }

    @Override
    public List<department> getAll() {
        return departRepo.findAll();
    }

    @Override
    public department addDepartment(department de) {
        return departRepo.save(de);
    }

    @Override
    public void deleteDepartment(int id) {
        departRepo.deleteById(id);
    }

    @Override
    public department updateDepartment(department de) {
        return departRepo.saveAndFlush(de);
    }
}
