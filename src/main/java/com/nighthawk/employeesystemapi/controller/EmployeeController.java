package com.nighthawk.employeesystemapi.controller;

import com.nighthawk.employeesystemapi.model.Employee;
import com.nighthawk.employeesystemapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/getEmployees")
    public String getEmployees() {
        return "Get All Employees";
    }

    @PostMapping("/addEmployee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

}
