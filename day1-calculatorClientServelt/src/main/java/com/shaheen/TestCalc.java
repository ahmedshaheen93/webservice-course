package com.shaheen;

public class TestCalc {
    public static void main(String[] args) {
        Calculator calculatorPort = new CalculatorService().getCalculatorPort();
        System.out.println("add 5 + 5 = " + calculatorPort.addNumbers(5, 5));
        System.out.println("sub 6 - 5 = " + calculatorPort.subNumbers(6.0f, 5.0f));
        System.out.println("mul 6 * 5 = " + calculatorPort.mulNumbers(6.0f, 5.0f));
        System.out.println("div 30 / 6 = " + calculatorPort.divNumbers(30.0f, 6.0f));
    }
}
