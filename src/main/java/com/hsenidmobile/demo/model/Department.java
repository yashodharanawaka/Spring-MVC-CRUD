/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/5/20, 3:28 PM.
 */

package com.hsenidmobile.demo.model;

import com.hsenidmobile.demo.model.enumtypes.DepartmentNameType;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public class Department {

    @OneToMany(mappedBy = "department")
    private final List<Employee> employees = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private short departmentId;

    @Enumerated(EnumType.STRING)
    @Column(unique = true, length = 20, name = "departmentName")
    private DepartmentNameType departmentName;

    public short getDepartmentId ( ) {
        return departmentId;
    }

    public void setDepartmentId (short departmentId) {
        this.departmentId = departmentId;
    }

    public DepartmentNameType getDepartmentName ( ) {
        return departmentName;
    }

    public void setDepartmentName (DepartmentNameType departmentName) {
        this.departmentName = departmentName;
    }

    public List<Employee> getEmployees ( ) {
        return employees;
    }
}
