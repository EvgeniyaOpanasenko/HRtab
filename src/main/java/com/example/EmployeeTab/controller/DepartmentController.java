package com.example.EmployeeTab.controller;

import com.example.EmployeeTab.model.Department;
import com.example.EmployeeTab.model.Employee;
import com.example.EmployeeTab.service.DepartmentService;
import com.example.EmployeeTab.utils.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/SpringBootCRUDApp/api")
public class DepartmentController {
    public static final Logger logger = LoggerFactory.getLogger(DepartmentController.class);

    @Autowired
    private DepartmentService departmentService;

    //returns list of all departments
    @RequestMapping(value = "/departments", method = RequestMethod.GET)
    public ResponseEntity<List<Department>> listAllDepartments() {
        List<Department> departments = departmentService.findAll();
        if (departments.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<List<Department>>(departments, HttpStatus.OK);
    }

    // returns details of some department without list of employees
    @RequestMapping(value = "/department/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartment(@PathVariable("id") long id) {
        logger.info("Finding department with id {}", id);
        Department department = departmentService.findById(id);
        if (department == null) {
            logger.error("Employee with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Department with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }

    //TODO  returns the list of employees assign to the current department
    @RequestMapping(value = "/department/{id}/employees", method = RequestMethod.GET)
    public ResponseEntity<?> getDepartmentEmployees(@PathVariable("id") long id) {
        logger.info("Finding department with id {} all employees", id);
        Department department = departmentService.findById(id);
        if (department == null) {
            logger.error("Employee with id {} not found.", id);
            return new ResponseEntity(new CustomErrorType("Employee with id " + id
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Department>(department, HttpStatus.OK);
    }
}
