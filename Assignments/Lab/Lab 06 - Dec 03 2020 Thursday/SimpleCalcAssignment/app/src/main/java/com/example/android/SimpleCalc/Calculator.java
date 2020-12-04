
package com.example.android.SimpleCalc;

public class Calculator {

    public enum Operator {ADD, SUB, DIV, MUL}

    public double add(double firstOperand, double secondOperand) {
        return firstOperand + secondOperand;
    }

    public double sub(double firstOperand, double secondOperand) {
        return firstOperand - secondOperand;
    }

    public double div(double firstOperand, double secondOperand) throws IllegalArgumentException {
        if(secondOperand==0) {throw new IllegalArgumentException("Cannot be divisible by zero"); }
        return firstOperand / secondOperand;
    }

    public double mul(double firstOperand, double secondOperand) {
        return firstOperand * secondOperand;
    }
}