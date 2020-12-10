/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/5/20, 1:34 PM.
 */

package com.hsenidmobile.demo.model;

import com.hsenidmobile.demo.model.compositekeys.EmployeeId;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table
public class Employee implements Serializable {

    @EmbeddedId
    private EmployeeId employeeId = new EmployeeId();

    @MapsId("departmentId")
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @Column(length = 10, nullable = false)
    private String nic;

    @Column(length = 50, nullable = false)
    private String emailID;

    @Column(length = 20, nullable = false)
    private String firstName;

    @Column(length = 20, nullable = false)
    private String lastName;

    @Column(length = 10, nullable = false)
    private String gender;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date dob;

    @Column(length = 30, nullable = false)
    private String designation;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private Date joinedDate;

    public Employee ( ) {
    }

    public Employee (EmployeeId employeeId, Department department, String nic, String emailID, String firstName,
                     String lastName, String gender, Date dob, String designation, Date joinedDate) {
        this.employeeId = employeeId;
        this.department = department;
        this.nic = nic;
        this.emailID = emailID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dob = dob;
        this.designation = designation;
        this.joinedDate = joinedDate;
    }

    public Department getDepartment ( ) {
        return department;
    }

    public void setDepartment (Department department) {
        this.department = department;
    }

    public String getNic ( ) {
        return nic;
    }

    public void setNic (String nic) {
        this.nic = nic;
    }

    public String getEmailID ( ) {
        return emailID;
    }

    public void setEmailID (String emailID) {
        this.emailID = emailID;
    }

    public String getFirstName ( ) {
        return firstName;
    }

    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName ( ) {
        return lastName;
    }

    public void setLastName (String lastName) {
        this.lastName = lastName;
    }

    public String getGender ( ) {
        return gender;
    }

    public void setGender (String gender) {
        this.gender = gender;
    }

    public Date getDob ( ) {
        return dob;
    }

    public void setDob (Date dob) {
        this.dob = dob;
    }

    public String getDesignation ( ) {
        return designation;
    }

    public void setDesignation (String designation) {
        this.designation = designation;
    }

    public Date getJoinedDate ( ) {
        return joinedDate;
    }

    public void setJoinedDate (Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public EmployeeId getEmployeeId ( ) {
        return employeeId;
    }

    public void setEmployeeId (EmployeeId employeeId) {
        this.employeeId = employeeId;
    }

}
