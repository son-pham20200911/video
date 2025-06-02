package com.example.repository;

import com.example.entity.department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface departmentRepository extends JpaRepository<department, Integer> {
}
