package com.shaheen;

import javax.jws.WebService;


@WebService
public class SayHelloImpl {
    public String sayHello(String name) {
        return String.format("Hello %s", name);
    }
}
