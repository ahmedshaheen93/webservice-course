package com.shaheen;

import java.util.List;

public class TestCurdOperation {

    public static void main(String[] args) {
        EmployeeServiceService employeeServiceService = new EmployeeServiceService();
        EmployeeService employeeServicePort = employeeServiceService.getEmployeeServicePort();

        Employee ahmed = new Employee();
        ahmed.setFirstName("ahmed");
        ahmed.setLastName("shaheen");
        ahmed.setEmail("ahmedshaheen676@yahoo.com");
        ahmed.setPhone("01061510304");
        ahmed.setPassword("test");

        Employee mohamed = new Employee();
        mohamed.setFirstName("mohamed");
        mohamed.setLastName("shaheen");
        mohamed.setEmail("mohamed@yahoo.com");
        mohamed.setPhone("000000");
        mohamed.setPassword("test");
        System.out.println("-------test insert");
        Employee insertedEmployee1 = employeeServicePort.insert(ahmed);
        Employee insertedEmployee2 = employeeServicePort.insert(mohamed);

        System.out.println(insertedEmployee1);
        System.out.println(insertedEmployee2);
        System.out.println("-------test find all");
        List<Employee> all = employeeServicePort.findAll();
        for (Employee employee : all) {
            System.out.println(employee);
        }

        Employee byId = employeeServicePort.getById(1);
        System.out.println(byId);
        System.out.println("-------test update");
        mohamed.setPhone("01097590252");
        employeeServicePort.update(mohamed);
        System.out.println("-------test delete");
        employeeServicePort.delete(1);
    }
}
