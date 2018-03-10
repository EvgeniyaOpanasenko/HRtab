package com.example.EmployeeTab.service;

import com.example.EmployeeTab.model.Department;
import com.example.EmployeeTab.repositoy.DepartmentRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Test
    public void find_all_employee_by_department_id_returns_dep_data_test() {
        Department department = new Department("testDepartment");
        departmentRepository.save(department);

        Optional<Department> result = departmentRepository.findById(department.getId());
        assertEquals("testDepartment", result.get().getName());
    }

    @Test
    public void find_all_departments_test() {
        Department d1 = new Department("testDepartment1");
        departmentRepository.save(d1);

        Department d2 = new Department("testDepartment2");
        departmentRepository.save(d2);

        List<Department> result = departmentRepository.findAll();
        assertEquals(2, result.size());
    }

    @Test
    public void save_department_test() {
        Department department = new Department("testDepartment");
        departmentRepository.save(department);
        Assert.assertNotNull(departmentRepository.findById(department.getId()));
    }

    @Test
    public void delete() {
        Department deleted = new Department("testDepartment");
        departmentRepository.save(deleted);

        Optional<Department> client = departmentRepository.findById(deleted.getId());
        assertEquals("testDepartment", client.get().getName());
    }
}