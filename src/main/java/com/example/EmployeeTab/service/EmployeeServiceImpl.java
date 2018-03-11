package com.example.EmployeeTab.service;

import com.example.EmployeeTab.model.Employee;
import com.example.EmployeeTab.repositoy.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findOne(id);
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }


    @Override
    public void update(Employee employee) {
        save(employee);
        //TODO check if one exist = > got it and assign new data
    }

    @Override
    public void delete(Employee employee) {
        employeeRepository.delete(employee);
    }

    @Override
    public boolean isEmployeeExist(Employee employee) {
        return employeeRepository.findByTaxNumber(employee.getTaxNumber()) != null;
    }
}
