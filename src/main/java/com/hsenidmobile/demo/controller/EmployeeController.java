/*
 * Copyright (c) 2020.
 * By Yashodha Ranawaka on 12/7/20, 12:43 PM.
 */

package com.hsenidmobile.demo.controller;

import com.hsenidmobile.demo.model.Employee;
import com.hsenidmobile.demo.model.compositekeys.EmployeeId;
import com.hsenidmobile.demo.model.enumtypes.DepartmentNameType;
import com.hsenidmobile.demo.repository.DepartmentRepository;
import com.hsenidmobile.demo.repository.EmployeeRepository;
import com.hsenidmobile.demo.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;

@Controller
@RequestMapping("employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String displayAllEmployees (Model model) {
        model.addAttribute("title", "All Employees");
        model.addAttribute("employees", employeeService.getAllEmployees());
        System.out.println(employeeService.getAllEmployees());
        return "employees/index";
    }

    //lives at /employees/add
    @GetMapping("add")
    public String renderAddEmployeeForm (Model model) {
        model.addAttribute("title", "Add Employee");
        model.addAttribute(new Employee());
        model.addAttribute("departments", departmentRepository.findAll());
        return "employees/add";
    }

    //lives at /employees/add
    @PostMapping("add")
    public String addEmployee (@ModelAttribute Employee employee, Model model
    ) {
        model.addAttribute("title", "All Employees");
        employeeService.addEmployee(employee);
        return "redirect:";
    }

    //lives at /employees/edit/{departmentId}/{employeeCode}
    @GetMapping("edit/{depId}/{empCode}")
    public String renderEditEmployeeForm (@PathVariable("depId") short depId,
                                          @PathVariable("empCode") long empCode, Model model) {
        EmployeeId id = new EmployeeId(empCode, depId);
        model.addAttribute("title", "Edit Employee");
        model.addAttribute("employee", employeeRepository.findByEmployeeId(id));
        model.addAttribute("departments", departmentRepository.findAll());
        return "employees/edit";
    }

    //lives at /employees/edit/{departmentId}/{employeeCode}
    @PostMapping("edit/{depId}/{empCode}")
    public String editEmployee (@PathVariable("depId") short depId,
                                @PathVariable("empCode") long empCode,
                                @ModelAttribute Employee employee,
                                Model model) {
        EmployeeId id = new EmployeeId(empCode, depId);
        employeeService.updateEmployee(employee, id);
        model.addAttribute("title", "Updated Employee Detail");
        return "redirect:/employees";
    }

    //lives at /employees/delete/{departmentId}/{employeeCode}
    @Transactional
    @GetMapping("delete/{depId}/{empCode}")
    public String deleteEmployee (@PathVariable("depId") short depId,
                                  @PathVariable("empCode") long empCode,
                                  @ModelAttribute Employee employee) {
        EmployeeId id = new EmployeeId(empCode, depId);
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }

    //lives at /employees/byName
    @GetMapping("/byName")
    public String renderEmployeeSearchByNameForm (Model model) {
        model.addAttribute("title", "Search");
        return "employees/search";
    }

    //    http://localhost:8080/searchByName?searchWord=Yashodha
    //lives at /employees/searchByName
    @GetMapping("/searchByName")
    public String displayEmployeeSearchByNameResults (@RequestParam(name = "searchWord") String name, Model model) {
        model.addAttribute("results", employeeService.getEmployeeByName(name));
        model.addAttribute("title", "View Employees by Name");
        return "employees/view";
    }

    //lives at /employees/byDepartment
    @GetMapping("/byDepartment")
    public String renderEmployeeSearchByDepartmentForm (Model model) {
        model.addAttribute("title", "Search");
        model.addAttribute("departmentNameTypes", DepartmentNameType.values());
        return "employees/search-department";
    }

    //lives at /employees/searchByDepartment
    @GetMapping("/searchByDepartment")
    public String displayEmployeeSearchByDepartmentResults (@RequestParam(name = "searchWord") String name, Model model) {
        model.addAttribute("results", employeeService.getEmployeesByDepartment(name));
        model.addAttribute("title", "View Employees by Department");
        return "employees/view";
    }
}
