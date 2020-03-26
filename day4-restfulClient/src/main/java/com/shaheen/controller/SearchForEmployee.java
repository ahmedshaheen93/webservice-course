package com.shaheen.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
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

@WebServlet("/employee")
public class SearchForEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/newEmployee");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        RestClient restClient = new RestClient();
        Response jsonEmployee = restClient.getJsonEmployee(Integer.valueOf(id));
        String employee = jsonEmployee.readEntity(String.class);
        Employee employee1;
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            employee1 = objectMapper.readValue(employee, Employee.class);
            if (employee1 != null && employee1.getId() > 0) {
                req.setAttribute("employee", employee1);
            }
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
            requestDispatcher.include(req, resp);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

    }
}