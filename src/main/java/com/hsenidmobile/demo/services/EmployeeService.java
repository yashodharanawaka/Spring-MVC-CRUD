/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/7/20, 12:03 PM.
 */

package com.hsenidmobile.demo.services;

import com.hsenidmobile.demo.model.Department;
import com.hsenidmobile.demo.model.Employee;
import com.hsenidmobile.demo.model.compositekeys.EmployeeId;
import com.hsenidmobile.demo.model.enumtypes.DepartmentNameType;
import com.hsenidmobile.demo.repository.DepartmentRepository;
import com.hsenidmobile.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Autowired
    DepartmentRepository departmentRepository;

    @Autowired
//    DepartmentNameTypeRepository departmentNameRepository;

    public Iterable<Employee> getAllEmployees ( ) {
        return employeeRepository.findAll();
    }

    public void addEmployee (Employee emp) {
        employeeRepository.save(emp);
    }

    public List<Employee> getEmployeeByName (String name) {
        List<Employee> list = new ArrayList<>();
        list.addAll(employeeRepository.findAllByFirstName(name));
        list.addAll(employeeRepository.findAllByLastName(name));
        return list;
    }

    public List<Employee> getEmployeesByDepartment (String depName) {
        DepartmentNameType departmentNameType=DepartmentNameType.valueOf(depName);
        Department dep = departmentRepository.findDepartmentByDepartmentName(departmentNameType);
        List<Employee> employees=employeeRepository.findAllByDepartment(dep);
        return employees;
    }

    public void updateEmployee (Employee emp, EmployeeId id) {git add

        Employee tempEmp = employeeRepository.findByEmployeeId(id);
        tempEmp.setDepartment(emp.getDepartment());
        tempEmp.setNic(emp.getNic());
        tempEmp.setEmailID(emp.getEmailID());
        tempEmp.setFirstName(emp.getFirstName());
        tempEmp.setLastName(emp.getLastName());
        tempEmp.setGender(emp.getGender());
        tempEmp.setDob(emp.getDob());
        tempEmp.setDesignation(emp.getDesignation());
        tempEmp.setJoinedDate(emp.getJoinedDate());
        employeeRepository.save(tempEmp);
    }

    public void deleteEmployee (EmployeeId empId) {
        employeeRepository.deleteByEmployeeId(empId);
    }

}
