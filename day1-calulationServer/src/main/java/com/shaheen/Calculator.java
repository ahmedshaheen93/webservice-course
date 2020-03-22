package com.shaheen;

import javax.jws.WebService;

@WebService
public class Calculator {
    public float addNumbers(float num1, float num2) {
        return num1 + num2;
    }

    public float subNumbers(Float num1, Float num2) {
        return num1 - num2;
    }

    public float divNumbers(Float num1, Float num2) {
        if (num2 == 0) {
            return Float.NaN;
        }
        return num1 / num2;
    }

    public float mulNumbers(Float num1, Float num2) {
        return num1 * num2;
    }
}
