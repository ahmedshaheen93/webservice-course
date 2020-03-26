package com.shaheen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.shaheen.Employee;
import com.shaheen.RestClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.List;

@WebServlet("/newEmployee")
public class SaveEmployee extends HttpServlet {
    RestClient restClient = new RestClient();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Response allJsonEmployee = restClient.getAllJsonEmployee();
        String jsonEmployees = allJsonEmployee.readEntity(String.class);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<Employee> employees = objectMapper.readValue(jsonEmployees, new TypeReference<List<Employee>>() {
            });
            System.out.println(employees);
            if (employees != null)
                req.setAttribute("employees", employees);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
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

        if (employee != null) {
            System.out.println(employee);

            Response jsonEmployee = restClient.createJsonEmployee(employee);
            if (jsonEmployee.getStatus() == 201) {
                req.setAttribute("employeeAdded", "employee add successfully");
            } else {
                req.setAttribute("erorrOnAdd", "error on add employee");
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.forward(req, resp);
        }
    }
}
