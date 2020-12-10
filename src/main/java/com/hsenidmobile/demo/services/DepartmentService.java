/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/8/20, 1:17 PM.
 */

package com.hsenidmobile.demo.services;

import com.hsenidmobile.demo.model.Department;
import com.hsenidmobile.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments ( ) {
        return (List<Department>) departmentRepository.findAll();
    }

    public void saveNewDepartment (Department dep) {
        departmentRepository.save(dep);
    }
}
