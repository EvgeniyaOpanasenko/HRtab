package com.example.EmployeeTab.service;

import com.example.EmployeeTab.model.Employee;

import java.util.List;

public interface EmployeeService {

    void findById(Long id);

    List<Employee> findAll();

    void save(Employee employee);

    // can assign the employee to some department
    void update(Employee employee);

    void delete(Employee employee);

}
