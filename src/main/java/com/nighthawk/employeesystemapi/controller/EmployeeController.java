package com.nighthawk.employeesystemapi.controller;

import com.nighthawk.employeesystemapi.model.Employee;
import com.nighthawk.employeesystemapi.services.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin(origins = "http://localhost:3000")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employee")
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee) {
        return employeeService.createEmployee(employee);
    }

    @DeleteMapping("/employee/{user_id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable Long user_id) {
        boolean deleted = false;
        deleted = employeeService.deleteEmployee(user_id);

        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", deleted);

        return ResponseEntity.ok(response);
    }

    @GetMapping("/employee/{user_id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable Long user_id) {
        Employee employee = null;
        employee = employeeService.getEmployeeById(user_id);

        return ResponseEntity.ok(employee);
    }

    @PutMapping("/employee/{user_id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long user_id, @RequestBody Employee employee) {
        employee = employeeService.updateEmployee(user_id, employee);

        return ResponseEntity.ok(employee);
    }

}
