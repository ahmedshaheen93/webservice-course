package com.shaheen.repository;

import com.shaheen.model.Employee;

import java.util.List;

public interface EmployeeRepository {
    List<Employee> findAll();

    Employee getById(int id);

    Employee insert(Employee employee);

    Employee update(Employee employee);

    void delete(int id);
}
