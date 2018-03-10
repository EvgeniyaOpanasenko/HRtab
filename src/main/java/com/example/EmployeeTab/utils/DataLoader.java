package com.example.EmployeeTab.utils;

import com.example.EmployeeTab.model.Employee;
import com.example.EmployeeTab.repositoy.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements ApplicationRunner {

    private EmployeeRepository employeeRepository;

    @Autowired
    public DataLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    //TODO remove id from constructor
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        employeeRepository.save(new Employee((long) 1256, "Eva", "Longoriya"));
    }
}
