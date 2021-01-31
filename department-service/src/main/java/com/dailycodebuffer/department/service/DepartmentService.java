package com.dailycodebuffer.department.service;

import com.dailycodebuffer.department.entity.Department;
import com.dailycodebuffer.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    private static final Logger log = LoggerFactory.getLogger(DepartmentService.class);

    public Department save(Department department) {
        log.info("Saving department {}", department);
        return departmentRepository.save(department);
    }

    public Department findById(Long id){
        log.info("Finding department by id {}.", id);
        return departmentRepository.findById(id).orElse(null);
    }

    public Collection<Department> findAll() {
        log.info("Finding all departments.");
        return departmentRepository.findAll();
    }
}
