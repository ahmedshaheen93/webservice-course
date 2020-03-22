package com.shaheen;

import javax.xml.ws.Endpoint;

public class StartService {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8088/hello", new SayHelloImpl());
        System.out.println("start service successfully ");

    }
}
