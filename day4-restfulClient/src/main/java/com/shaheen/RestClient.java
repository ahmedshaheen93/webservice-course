package com.shaheen;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

public class RestClient {

    private static final String REST_URI = "http://localhost:8080/day4_restfulApi_war/api/v1/employees";
    private Client client = ClientBuilder.newClient();

    public Response createJsonEmployee(Employee emp) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON).post(Entity.entity(emp, MediaType.APPLICATION_JSON));
    }

    public Response getJsonEmployee(int id) {
        return client.target(REST_URI).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response getAllJsonEmployee() {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .get();
    }

    public Response createXmlEmployee(Employee emp) {
        return client.target(REST_URI).request(MediaType.APPLICATION_XML).post(Entity.entity(emp, MediaType.APPLICATION_XML));
    }

    public Employee getXmlEmployee(int id) {
        return client.target(REST_URI).path(String.valueOf(id)).request(MediaType.APPLICATION_XML).get(Employee.class);
    }
}