package com.example.EmployeeTab.repositoy;

import com.example.EmployeeTab.model.Department;
import com.example.EmployeeTab.model.Employee;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional(readOnly = true)
public class EmployeeRepositoryImpl implements EmployeeRepositoryCustom {

    @PersistenceContext
    EntityManager entityManager;

    //TODO need to think what exactly it must return
    @Override
    public List<Employee> findDepartmentDetails(Long id) {
        Query query = entityManager.createNativeQuery("SELECT name* FROM departments as name " +
                "WHERE id LIKE ?", Department.class);
        query.setParameter(1, id + "%");
        return query.getResultList();
    }
}
