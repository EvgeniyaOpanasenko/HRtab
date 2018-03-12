package com.example.EmployeeTab.controller;

import com.example.EmployeeTab.model.Employee;
import com.example.EmployeeTab.service.EmployeeService;
import com.example.EmployeeTab.utils.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("/SpringBootCRUDApp/api")
public class EmployeeController {
    public static final Logger logger = LoggerFactory.getLogger(EmployeeController.class);

    @Autowired
    private EmployeeService employeeService;

    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    public ResponseEntity<List<Employee>> listAllEmployees() {
        List<Employee> employees = employeeService.findAll();
        if (employees.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Employee>>(employees, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getEmployee(@PathVariable("id") long id) {
        logger.info("Finding employee with id {}", id);
        Employee employee = employeeService.findById(id);
        if (employee == null) {
            logger.error("Employee with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Employee with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Employee>(employee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee", method = RequestMethod.POST)
    public ResponseEntity<?> createEmployee(@RequestBody Employee employee, UriComponentsBuilder ucBuilder) {
        logger.info("Creating Employee : {}", employee);

        if (employeeService.isEmployeeExist(employee)) {
            logger.error("Unable to create. An Employee with taxNumber {} already exist", employee.getTaxNumber());
            return new ResponseEntity(new CustomErrorType("Unable to create. An employee with taxNumber " +
                    employee.getTaxNumber() + " already exist."), HttpStatus.CONFLICT);
        }
        employeeService.save(employee);

        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(ucBuilder.path("/SpringBootCRUDApp/api/employee/{id}").buildAndExpand(employee.getId()).toUri());
        logger.info("Created Employee : {}", employee.getId());
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateEmployee(@PathVariable("id") long id, @RequestBody Employee employee) {
        logger.info("Updating Employee with id {}", id);

        Employee currentEmployee = employeeService.findById(id);

        if (currentEmployee == null) {
            logger.error("Unable to update. Employee with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to upate. Employee with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }

        currentEmployee.setFirstName(employee.getFirstName());
        currentEmployee.setLastName(employee.getLastName());
        currentEmployee.setBirthday(employee.getBirthday());
        currentEmployee.setDepartment(employee.getDepartment());
        currentEmployee.setGender(employee.getGender());
        currentEmployee.setTaxNumber(employee.getTaxNumber());

        employeeService.update(currentEmployee);
        return new ResponseEntity<Employee>(currentEmployee, HttpStatus.OK);
    }

    @RequestMapping(value = "/employee/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteEmployee(@PathVariable("id") long id) {
        logger.info("Fetching & Deleting Employee with id {}", id);

        Employee employee = employeeService.findById(id);
        if (employee == null) {
            logger.error("Unable to delete. Employee with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Unable to delete. Employee with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        employeeService.delete(employee);
        return new ResponseEntity<Employee>(HttpStatus.NO_CONTENT);
    }
}
