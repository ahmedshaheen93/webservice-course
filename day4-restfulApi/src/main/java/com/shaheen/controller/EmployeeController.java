package com.shaheen.controller;

import com.shaheen.model.Employee;
import com.shaheen.response.ResponseMessage;
import com.shaheen.service.EmployeeService;
import com.shaheen.service.EmployeeServiceImpl;

import javax.ws.rs.*;
import javax.ws.rs.core.GenericEntity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employees")
@Produces(MediaType.APPLICATION_JSON)
public class EmployeeController {
    EmployeeService employeeService = new EmployeeServiceImpl();

    @GET
    public Response get() {

        List<Employee> all = employeeService.findAll();
        GenericEntity<List<Employee>> entity = new GenericEntity<List<Employee>>(all) {
        };
        return Response.ok().entity(entity).build();


    }

    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.TEXT_HTML})
    public Response getById(@PathParam("id") int id) {
        if (id < 0) {
            return Response.noContent().build();
        }
        Employee employee = employeeService.findById(id);
        GenericEntity<Employee> entity = new GenericEntity<>(employee, Employee.class);
        return Response.ok().entity(entity).build();
    }

    @POST
    public Response add(Employee employee) {
        System.out.println("post called");

        employee = employeeService.save(employee);
        GenericEntity<Employee> entity = new GenericEntity<>(employee, Employee.class);
        return Response.status(Response.Status.CREATED).entity(entity).build();

    }

    @PUT
    public Response update(Employee employee) {
        System.out.println("put called");
        employee = employeeService.save(employee);
        GenericEntity<Employee> entity = new GenericEntity<>(employee, Employee.class);
        return Response.status(Response.Status.OK).entity(entity).build();
    }

    @DELETE
    @Path("/{id}")
    public ResponseMessage delete(@PathParam("id") int id) {
        System.out.println("del called");
        return employeeService.delete(id);
    }
}
