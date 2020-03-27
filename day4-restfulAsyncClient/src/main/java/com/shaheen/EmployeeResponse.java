package com.shaheen;


import java.util.ArrayList;
import java.util.List;

public class EmployeeResponse {
    Employee employee;
    List<String> links = new ArrayList<>();

    public EmployeeResponse() {
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<String> getLinks() {
        return links;
    }

}
