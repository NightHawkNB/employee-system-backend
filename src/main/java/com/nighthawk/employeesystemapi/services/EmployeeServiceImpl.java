package com.nighthawk.employeesystemapi.services;

import com.nighthawk.employeesystemapi.entity.EmployeeEntity;
import com.nighthawk.employeesystemapi.model.Employee;
import com.nighthawk.employeesystemapi.repository.EmployeeRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;


import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee createEmployee(Employee employee) {
        EmployeeEntity employeeEntity = new EmployeeEntity();

        BeanUtils.copyProperties(employee, employeeEntity);
        employeeRepository.save(employeeEntity);

        return employee;
    }

    @Override
    public List<Employee> getAllEmployees() {

        List<EmployeeEntity> employeeEntities = employeeRepository.findAll();

        return employeeEntities
                .stream()
                .map(emp -> new Employee(
                        emp.getId(),
                        emp.getFirstname(),
                        emp.getLastname(),
                        emp.getEmail()
                    )
                )
                .collect(Collectors.toList());
    }

    @Override
    public boolean deleteEmployee(Long user_id) {

        EmployeeEntity employee = employeeRepository.findById(user_id).get();
        employeeRepository.delete(employee);

        return true;
    }

    @Override
    public Employee getEmployeeById(Long user_id) {

        EmployeeEntity employeeEntity = employeeRepository.findById(user_id).get();

        Employee employee = new Employee();

        BeanUtils.copyProperties(employeeEntity, employee);

        return employee;
    }

    @Override
    public Employee updateEmployee(Long user_id, Employee employee) {

        EmployeeEntity employeeEntity = employeeRepository.findById(user_id).get();

        employeeEntity.setFirstname(employee.getFirstname());
        employeeEntity.setLastname(employee.getLastname());
        employeeEntity.setEmail(employee.getEmail());
        employeeRepository.save(employeeEntity);

        return employee;
    }
}
