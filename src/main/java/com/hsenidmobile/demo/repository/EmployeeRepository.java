/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/7/20, 9:49 AM.
 */

package com.hsenidmobile.demo.repository;

import com.hsenidmobile.demo.model.Department;
import com.hsenidmobile.demo.model.Employee;
import com.hsenidmobile.demo.model.compositekeys.EmployeeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, EmployeeId> {

//    @Query("SELECT e FROM employee e WHERE PERIOD_DIFF(YEAR(CURDATE()),YEAR(e.joined_date))>5 nativeQuery = true")
//    List<Employee> findAllEmployeesWhoWorkedForMoreThan5YearsAnsBornIn90();

    List<Employee> findAllByDepartment (Department department);

    List<Employee> findAllByFirstName (String search);

    List<Employee> findAllByLastName (String search);

    Employee findByEmployeeId (EmployeeId employeeId);

    void deleteByEmployeeId (EmployeeId empId);

}
