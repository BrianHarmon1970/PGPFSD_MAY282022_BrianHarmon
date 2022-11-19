package com.example.repository;
import com.example.Entity.Employee ;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.support.CrudMethodMetadata;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public abstract class EmployeeRepository implements JpaRepository<Employee, Long> {
    @Override
    public List<Employee> findAll() {
        return null;
    }
}
