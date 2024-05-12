package com.nighthawk.employeesystemapi.services;

import com.nighthawk.employeesystemapi.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee createEmployee(Employee employee);

    List<Employee> getAllEmployees();

    boolean deleteEmployee(Long user_id);

    Employee getEmployeeById(Long user_id);

    Employee updateEmployee(Long user_id, Employee employee);
}
