package com.shaheen.service;

import com.shaheen.model.Employee;
import com.shaheen.response.ResponseMessage;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int id);

    Employee save(Employee employee);

    ResponseMessage delete(int id);
}
