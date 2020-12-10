/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/8/20, 10:46 AM.
 */

package com.hsenidmobile.demo.model.enumtypes;

public enum DepartmentNameType {
    Ravenclaw("Ravenclaw"),
    Hufflepuff("Hufflepuff"),
    Gryffindor("Gryffindor"),
    Slytherin("Slytherin");


    private final String departmentName;

    DepartmentNameType (String departmentName) {
        this.departmentName = departmentName;
    }

    public String getDepartmentName ( ) {
        return departmentName;
    }

}
