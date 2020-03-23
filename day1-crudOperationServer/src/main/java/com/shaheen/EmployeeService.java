package com.shaheen;

import javax.jws.WebService;
import java.util.List;

@WebService
public class EmployeeService implements EmployeeRepository {
    EmployeeRepository employeeRepository = new EmployeeRepositoryImpl();

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(int id) {
        return employeeRepository.getById(id);
    }

    @Override
    public Employee insert(Employee employee) {
        return employeeRepository.insert(employee);
    }

    @Override
    public Employee update(Employee employee) {
        return employeeRepository.update(employee);
    }

    @Override
    public void delete(int id) {
        employeeRepository.delete(id);
    }
}
