package com.example.EmployeeTab.service;

import com.example.EmployeeTab.model.Employee;

import java.util.List;

public interface EmployeeService {

    Employee findById(Long id);

    List<Employee> findAll();

    Employee save(Employee employee);

    // can assign the employee to some department
    void update(Employee employee);

    void delete(Employee employee);

    boolean isEmployeeExist(Employee employee);
}
