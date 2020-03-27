package com.shaheen;

import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import javax.ws.rs.core.MediaType;
import java.io.IOException;

public class RestClient {

    private static final String REST_URI = "http://localhost:8080/server/api/v1/employees";
    CloseableHttpClient httpClient = HttpClients.createDefault();

    //
    public HttpResponse createJsonEmployee(Employee emp) {
        try {
            System.out.println("inside create method");
            HttpPost httpPost = new HttpPost(REST_URI);
            StringEntity entity = new StringEntity(emp.toString(), ContentType.APPLICATION_JSON);
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", MediaType.APPLICATION_JSON);
            httpPost.setHeader("Content-type", MediaType.APPLICATION_JSON);
            return httpClient.execute(httpPost);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpResponse updateJsonEmployee(Employee emp) {
        try {
            HttpPut httpPut = new HttpPut(REST_URI);
            httpPut.addHeader("Accept", MediaType.APPLICATION_JSON);
            httpPut.addHeader("Content-type", MediaType.APPLICATION_JSON);
            StringEntity userEntity = new StringEntity(emp.toString());
            httpPut.setEntity(userEntity);
            return httpClient.execute(httpPut);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //
    public HttpResponse getJsonEmployee(int id) {
        try {
            System.out.println("inside getJsonEmployee");
            HttpGet getRequest = new HttpGet(REST_URI + "/" + id);
            getRequest.addHeader("Accept", MediaType.APPLICATION_JSON);
            return httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpResponse getAllJsonEmployee() {
        try {
            HttpGet getRequest = new HttpGet(REST_URI);
            getRequest.addHeader("Accept", MediaType.APPLICATION_JSON);
            return httpClient.execute(getRequest);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}