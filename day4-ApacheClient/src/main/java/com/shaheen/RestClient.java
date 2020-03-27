package com.shaheen;

import org.apache.http.HttpException;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpPut;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.net.URISyntaxException;

public class RestClient {

    private static final String REST_URI = "http://localhost:8080/server/api/v1/employees";
    private DefaultHttpClient httpClient = new DefaultHttpClient();

    public HttpResponse createJsonEmployee(Employee emp) {
        try {
            System.out.println("inside create method");
            HttpPost httpPost = new HttpPost(REST_URI);
            httpPost.addHeader("accept", MediaType.APPLICATION_JSON);
            httpPost.addHeader("content-type", MediaType.APPLICATION_JSON);
            StringEntity userEntity = new StringEntity(emp.toString());
            System.out.println(userEntity);
            httpPost.setEntity(userEntity);
            HttpResponse execute = httpClient.execute(httpPost);
            System.out.println("response= " + execute);
            System.out.println("response code= " + execute.getStatusLine().getStatusCode());
            System.out.println("response entity= " + execute.getEntity());
            return execute;
        } catch (IOException | HttpException | URISyntaxException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpResponse updateJsonEmployee(Employee emp) {
        try {
            HttpPut httpPut = new HttpPut(REST_URI);
            httpPut.addHeader("accept", MediaType.APPLICATION_JSON);
            httpPut.addHeader("content-type", MediaType.APPLICATION_JSON);
            StringEntity userEntity = new StringEntity(emp.toString());
            httpPut.setEntity(userEntity);
            return httpClient.execute(httpPut);
        } catch (URISyntaxException | HttpException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    //
    public HttpResponse getJsonEmployee(int id) {
        try {
            HttpGet getRequest = new HttpGet(REST_URI + "/" + id);
            getRequest.addHeader("accept", MediaType.APPLICATION_JSON);
            return httpClient.execute(getRequest);
        } catch (URISyntaxException | HttpException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public HttpResponse getAllJsonEmployee() {
        try {
            HttpGet getRequest = new HttpGet(REST_URI);
            getRequest.addHeader("accept", MediaType.APPLICATION_JSON);
            HttpResponse response = httpClient.execute(getRequest);
            return response;
        } catch (URISyntaxException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (HttpException e) {
            e.printStackTrace();
        }
        return null;
    }
}