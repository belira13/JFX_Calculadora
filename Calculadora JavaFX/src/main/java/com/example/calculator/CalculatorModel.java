package com.example.calculator;

public class CalculatorModel {
    //Campos ou Propriedades

    //Método Construtor

    //Método ou Comportamento
    public double calculator(double number1, double number2, String operator) {
        switch (operator){
            case "+":
                return calculateAddition(number1, number2);
            case "-":
                return calculateSubtraction(number1, number2);
            case "x":
                return calculateMultiplication(number1, number2);
            case "/":
                return calculateDivision(number1, number2);
            case "%":
                return calculatePercent(number1, number2);

            default:
                System.out.println("Operador desconhecido");
                return 0;
        }
    }
    private double calculateAddition(double n1, double n2){
        return n1 + n2;
    }
    private double calculateSubtraction(double n1, double n2){
        return n1 - n2;
    }
    private double calculateMultiplication(double n1, double n2){
        return n1 * n2;
    }
    private double calculateDivision(double n1, double n2){
        return (n2==0) ? 0 : (n1 / n2);
    }
    private double calculatePercent(double n1, double n2){
        return n1 /100 * n2;
    }
}
