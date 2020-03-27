package com.shaheen;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.concurrent.Future;

public class RestClient {
    private static final String REST_URI = "http://localhost:8080/server/api/v1/employees";
    private Client client = ClientBuilder.newClient();


    public Future<Response> createJsonEmployee(Employee emp) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON).async().post(Entity.entity(emp, MediaType.APPLICATION_JSON));
    }

    public Future<Response> updateJsonEmployee(Employee emp) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON).async().put(Entity.entity(emp, MediaType.APPLICATION_JSON));
    }

    public Future<Response> getJsonEmployee(int id) {
        return client.target(REST_URI).path(String.valueOf(id)).request(MediaType.APPLICATION_JSON)
                .async().get();
    }

    public Future<Response> getAllJsonEmployee() {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .async().get();
    }

}