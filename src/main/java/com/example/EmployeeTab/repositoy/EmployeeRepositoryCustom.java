package com.example.EmployeeTab.repositoy;

import com.example.EmployeeTab.model.Employee;

import java.util.List;

public interface EmployeeRepositoryCustom {
    List<Employee> findDepartmentDetails(Long id);
}
