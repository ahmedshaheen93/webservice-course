package com.shaheen.service;

import com.shaheen.model.Employee;
import com.shaheen.repository.EmployeeRepository;
import com.shaheen.repository.EmployeeRepositoryImpl;
import com.shaheen.response.EmployeeResponse;
import com.shaheen.response.ResponseMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;
    private final List<String> links = Arrays.asList("/employees", "/employees/{id}");

    public EmployeeServiceImpl() {
        employeeRepository = new EmployeeRepositoryImpl();
    }

    @Override
    public List<Employee> findAll() {
        List<EmployeeResponse> response = new ArrayList<>();

        return employeeRepository.findAll();

    }

    @Override
    public Employee findById(int id) {
//        Employee employee = employeeRepository.getById(id);
        return employeeRepository.getById(id);
//        if (employee != null && employee.getId() > 0) {
//            EmployeeResponse employeeResponse = getEmployeeResponse(employee);
//            return employeeResponse;
//        } else {
//            //return error message
//            return null;
//        }
    }

    private EmployeeResponse getEmployeeResponse(Employee employee) {
        EmployeeResponse employeeResponse = new EmployeeResponse();
        employeeResponse.setLinks(links);
        employeeResponse.setEmployee(employee);
        return employeeResponse;
    }

    @Override
    public Employee save(Employee employee) {
        if (employee.getId() > 0) {
            return employeeRepository.update(employee);
        } else {
            return employeeRepository.insert(employee);
        }
    }

    @Override
    public ResponseMessage delete(int id) {
        employeeRepository.delete(id);
        ResponseMessage responseMessage = new ResponseMessage();
        responseMessage.setMessage("deleted successfully");
        responseMessage.setStatusCode(200);
        return responseMessage;
    }
}
