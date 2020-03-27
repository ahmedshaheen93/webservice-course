package com.shaheen.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.shaheen.Employee;
import com.shaheen.RestClient;
import com.shaheen.Utility;
import org.apache.http.HttpResponse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;


@WebServlet("/newEmployee")
public class NewEmployee extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RestClient restClient = new RestClient();
        HttpResponse allJsonEmployee = restClient.getAllJsonEmployee();
        if (allJsonEmployee != null) {
            List<Employee> employees = new Utility<List<Employee>>().map(allJsonEmployee, new TypeReference<>() {
            });
            System.out.println(employees);
            if (employees != null) {
                req.setAttribute("employees", employees);
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstname = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        Employee employee = new Employee();
        employee.setFirstName(firstname);
        employee.setLastName(lastName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setPassword(password);
        System.out.println(employee);
        RestClient restClient = new RestClient();
        HttpResponse jsonEmployee = restClient.createJsonEmployee(employee);

        if (jsonEmployee != null && jsonEmployee.getStatusLine().getStatusCode() == 201) {
            req.setAttribute("employeeAdded", "employee add successfully");
        } else {
            req.setAttribute("erorrOnAdd", "error on add employee");
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.forward(req, resp);

    }
}
