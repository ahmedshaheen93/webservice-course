package com.shaheen;

public class SayMyName {
    public static void main(String[] args) {
        SayHelloImpl sayHelloImplPort = new SayHelloImplService().getSayHelloImplPort();
        System.out.println(sayHelloImplPort.sayHello("ahmed"));

    }
}
