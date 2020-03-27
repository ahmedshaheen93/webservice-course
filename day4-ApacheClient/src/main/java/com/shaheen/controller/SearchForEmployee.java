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

@WebServlet("/employee")
public class SearchForEmployee extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/newEmployee");
        requestDispatcher.include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("empID");
        RestClient restClient = new RestClient();
        if (id != null) {
            HttpResponse jsonEmployee = restClient.getJsonEmployee(Integer.parseInt(id.trim()));
            if (jsonEmployee != null && jsonEmployee.getStatusLine().getStatusCode() == 200) {
                Employee employee = new Utility<Employee>().map(jsonEmployee, new TypeReference<Employee>() {
                });
                System.out.println(employee);
                if (employee != null && employee.getId() > 0) {
                    req.setAttribute("employee", employee);
                }
            }
        }
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("index.jsp");
        requestDispatcher.include(req, resp);

    }
}
