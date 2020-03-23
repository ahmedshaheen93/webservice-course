package com.shaheen;

import java.util.List;

public interface EmployeeCrud {
    List<Employee> findAll();

    Employee getById(int id);

    Employee insert(Employee employee);

    Employee update(Employee employee);

    void delete(int id);

}
