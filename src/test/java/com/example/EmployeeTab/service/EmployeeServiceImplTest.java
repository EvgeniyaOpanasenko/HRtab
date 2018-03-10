package com.example.EmployeeTab.service;

import com.example.EmployeeTab.model.Employee;
import com.example.EmployeeTab.repositoy.EmployeeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {

    private static final String LAST_NAME = "Ivanov";
    private static final String FIRST_NAME = "Ivan";
    private static final Long PERSON_ID = Long.valueOf(112);

    @TestConfiguration
    static class EmployeeServiceImplTestContextConfiguration {

        @Bean
        public EmployeeService employeeService() {
            return new EmployeeServiceImpl();
        }
    }

    @Autowired
    private EmployeeService employeeService;

    @MockBean
    private EmployeeRepository employeeRepository;

    @Test
    public void when_find_by_id_then_return_employee() {
        Employee employee = new Employee(PERSON_ID, FIRST_NAME, LAST_NAME);
        employeeRepository.save(employee);

        when(employeeRepository.findOne(PERSON_ID))
                .thenReturn((employee));

        Employee result = employeeService.findById(PERSON_ID);

        verify(employeeRepository, times(1)).findOne(PERSON_ID);

        assertEquals(employee, result);
    }
}