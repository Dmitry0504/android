package com.example.calculator;

public class MathFunction {

    public double sum(double a, double b) {
        return a + b;
    }

    public double minus(double a, double b) {
        return a - b;
    }

    public double divide(double a, double b) {
        if (b == 0)
            return 0;
        return a / b;
    }

    public double multiply(double a, double b) {
        return a * b;
    }

    public double sqrt(double a) {
        return Math.sqrt(a);
    }
}
