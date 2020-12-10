/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/8/20, 11:43 AM.
 */

package com.hsenidmobile.demo.controller;

import com.hsenidmobile.demo.model.Department;
import com.hsenidmobile.demo.model.enumtypes.DepartmentNameType;
import com.hsenidmobile.demo.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("departments")
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @GetMapping
    public String displayAllDepartments (Model model) {
        model.addAttribute("departments", departmentService.getAllDepartments());
        System.out.println(departmentService.getAllDepartments());
        return "departments/index";
    }

    //lives at /departments/add
    @GetMapping("add")
    public String renderAddDepartmentForm (Model model) {
        model.addAttribute("title", "Add Department");
        model.addAttribute(new Department());
        model.addAttribute("departmentNameTypes", DepartmentNameType.values());
        return "departments/add";
    }

    //lives at /departments/add
    @PostMapping("add")
    public String addDepartment (@ModelAttribute Department department) {
        departmentService.saveNewDepartment(department);
        return "redirect:";
    }
}
