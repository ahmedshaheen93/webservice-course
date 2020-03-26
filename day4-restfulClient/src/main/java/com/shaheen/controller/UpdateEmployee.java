package com.shaheen.controller;

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

@WebServlet("/updateEmployee")
public class UpdateEmployee extends HttpServlet {
    RestClient restClient = new RestClient();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/newEmployee");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("hiii");
        String id = req.getParameter("id");
        String firstname = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        System.out.println(id);
        Employee employee = new Employee();
        employee.setId(Integer.parseInt(id.trim()));
        employee.setFirstName(firstname);
        employee.setLastName(lastName);
        employee.setPhone(phone);
        employee.setEmail(email);
        employee.setPassword(password);
//
        System.out.println(employee);
        Response jsonEmployee = restClient.updateJsonEmployee(employee);
        if (jsonEmployee.getStatus() == 200) {
            req.setAttribute("employeeUpdated", "employee updated successfully");
        } else {
            req.setAttribute("employeeUpdated", "error on update employee");
        }
        System.out.println("update suuuuuuu");
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req, resp);

    }
}
