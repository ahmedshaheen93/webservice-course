package com.shaheen;

public class TestHello {
    public static void main(String[] args) {
        HelloServiceImpl helloServiceImplPort = new HelloServiceImplService().getHelloServiceImplPort();
        System.out.println(helloServiceImplPort.sayHello("ahmed"));
    }
}
