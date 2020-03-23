package com.shaheen;

import javax.jws.WebService;

@WebService
public class HelloServiceImpl {
    public String sayHello(String name) {
        return "hello " + name;
    }
}
