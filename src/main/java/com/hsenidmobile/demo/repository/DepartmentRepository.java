/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/7/20, 6:52 PM.
 */

package com.hsenidmobile.demo.repository;

import com.hsenidmobile.demo.model.Department;
import com.hsenidmobile.demo.model.enumtypes.DepartmentNameType;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department, Short> {

    Department findDepartmentByDepartmentName (DepartmentNameType name);

}
