package com.example.EmployeeTab.service;

import com.example.EmployeeTab.model.Department;
import com.example.EmployeeTab.model.Employee;

import java.util.List;

public interface DepartmentService {

    void findById(Long id);

    List<Department> findAll();

    List<Department> findAllEmployeeByDepartment(Long id);

    void save(Department department);

    void update(Department department);

    void delete(Department department);

}
