/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/8/20, 10:26 AM.
 */

package com.hsenidmobile.demo.model.compositekeys;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class EmployeeId implements Serializable {

    //    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Generated(GenerationTime.INSERT)
    @Column(name = "employee_code", columnDefinition = "serial")
    long employeeCode;

    @Column(name = "department_id")
    short departmentId;

    public EmployeeId ( ) {

    }

    public EmployeeId (long employeeCode, short departmentId) {
        this.employeeCode = employeeCode;
        this.departmentId = departmentId;
    }

    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EmployeeId that = (EmployeeId) o;
        return employeeCode == that.employeeCode &&
                departmentId == that.departmentId;
    }

    @Override
    public int hashCode ( ) {
        return Objects.hash(employeeCode, departmentId);
    }

    public long getEmployeeCode ( ) {
        return employeeCode;
    }

    public void setEmployeeCode (long employeeCode) {
        this.employeeCode = employeeCode;
    }

    @Getter
    public short getDepartmentId ( ) {
        return departmentId;
    }

    @Setter
    public void setDepartmentId (short departmentId) {
        this.departmentId = departmentId;
    }
}
