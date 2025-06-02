package com.example.repository;

import com.example.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface employeeRepository extends JpaRepository<employee,Integer> {

}
