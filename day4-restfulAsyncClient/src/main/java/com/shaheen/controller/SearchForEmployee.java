package com.shaheen.controller;

import com.shaheen.Employee;
import com.shaheen.RestClient;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.Response;
import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
        RequestDispatcher requestDispatcher = null;
        System.out.println(id);
        if (id != null) {
            try {
                Future<Response> jsonEmployee = restClient.getJsonEmployee(Integer.parseInt(id.trim()));
                //test non blocking method
                requestDispatcher = req.getRequestDispatcher("index.jsp");

                Employee employee = jsonEmployee.get(5000, TimeUnit.MILLISECONDS).readEntity(new GenericType<>() {
                });
                if (employee != null && employee.getId() > 0) {
                    req.setAttribute("employee", employee);
                }
            } catch (NumberFormatException | InterruptedException | ExecutionException | TimeoutException e) {
                e.printStackTrace();
                req.setAttribute("errorMessage", e.getMessage());
                req.setAttribute("errorNumber", "400");

                requestDispatcher = req.getRequestDispatcher("error.jsp");
            }
        } else {
            req.setAttribute("errorMessage", "not found");
            req.setAttribute("errorNumber", "406");
            requestDispatcher = req.getRequestDispatcher("error.jsp");
        }
        requestDispatcher.include(req, resp);

    }
}
