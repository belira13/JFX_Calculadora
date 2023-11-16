package com.example.calculator;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class CalculatorController {
    //  Vaiáveis FXML
    @FXML
    private Label output;
    @FXML
    private Label output_Calc;
    @FXML
    private Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_backspace, btn_del, btn_add, btn_minus, btn_equals, btn_mult, btn_divide;
    @FXML
    private Button btn_dot;


    //Variáveis
    private boolean calculating = false;
    private boolean hasDot = false;
    private String operator = "";
    private double number1 = 0.0;
    private double number2 = 0.0;
    private boolean outputClean = false;

    //objetos
    CalculatorModel model = new CalculatorModel();

    //Métodos FXML
    @FXML
    protected void onProcessNumber(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();


        if (!calculating) {
            calculating = true;
            output.setText("0");
            output_Calc.setText("0");
            outputClean = true;
        }

        if (outputClean) {
            output.setText("");
            outputClean = false;
        }
        output.setText(output.getText() + value);
    }

    @FXML
    protected void onProcessOperator(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (!value.equals("=")) {
            if (operator.isEmpty()) {
                operator = value;
                number1 = Double.parseDouble(output.getText());
                output_Calc.setText(output.getText() + " " + value);
                outputClean = true;
                hasDot = false;
            }
        } else {
            number2 = Double.parseDouble(output.getText());
            output_Calc.setText(output_Calc.getText() + " " + output.getText() + " =");

            double result = model.calculator(number1, number2, operator);
            String sResult = "";

            //verifica se resultado é inteiro
            if ((int) result - result == 0) {
                sResult = Integer.toString((int) result);
            } else {
                sResult = Double.toString(result);
            }

            output.setText(sResult);
            calculating = false;
            operator = "";
            hasDot = false;
        }

    }

    @FXML
    protected void onProgressAllClean(ActionEvent event) {
        calculating = false;
        operator = "";
        output.setText("0");
        output_Calc.setText("0");
        number1 = 0.0;
        number2 = 0.0;
        hasDot = false;
    }

    @FXML
    protected void onProgressClean(ActionEvent event) {
        int textLength = output.getText().length();

        if (textLength > 0){
            output.setText(output.getText().substring(0, --textLength));
        }

        if (textLength == 0){
            output.setText("0");
            outputClean = true;
        }
    }

    @FXML
    protected void onProcessDot(ActionEvent event) {
        String value = ((Button) event.getSource()).getText();

        if (hasDot) {
            return;
        }

        output.setText(output.getText() + value);
        hasDot = true;
    }

    @FXML
    protected void onProgressKeyPress(KeyEvent event) {
        System.out.println(event.getCode());

        //número 0
        if (event.getCode().equals(KeyCode.DIGIT0) || event.getCode().equals(KeyCode.NUMPAD0)) {
            btn_0.fire();
            return;
        }

        //número 1
        if (event.getCode().equals(KeyCode.DIGIT1) || event.getCode().equals(KeyCode.NUMPAD1)) {
            btn_1.fire();
            return;
        }

        //número 2
        if (event.getCode().equals(KeyCode.DIGIT2) || event.getCode().equals(KeyCode.NUMPAD2)) {
            btn_2.fire();
            return;
        }

        //número 3
        if (event.getCode().equals(KeyCode.DIGIT3) || event.getCode().equals(KeyCode.NUMPAD3)) {
            btn_3.fire();
            return;
        }

        //número 4
        if (event.getCode().equals(KeyCode.DIGIT4) || event.getCode().equals(KeyCode.NUMPAD4)) {
            btn_4.fire();
            return;
        }

        //número 5
        if (event.getCode().equals(KeyCode.DIGIT5) || event.getCode().equals(KeyCode.NUMPAD5)) {
            btn_5.fire();
            return;
        }

        //número 6
        if (event.getCode().equals(KeyCode.DIGIT6) || event.getCode().equals(KeyCode.NUMPAD6)) {
            btn_6.fire();
            return;
        }

        //número 7
        if (event.getCode().equals(KeyCode.DIGIT7) || event.getCode().equals(KeyCode.NUMPAD7)) {
            btn_7.fire();
            return;
        }

        //número 8
        if (event.getCode().equals(KeyCode.DIGIT8) || event.getCode().equals(KeyCode.NUMPAD8)) {
            btn_8.fire();
            return;
        }

        //número 9
        if (event.getCode().equals(KeyCode.DIGIT9) || event.getCode().equals(KeyCode.NUMPAD9)) {
            btn_9.fire();
            return;
        }

        //backspace
        if (event.getCode().equals(KeyCode.BACK_SPACE)) {
            btn_backspace.fire();
            return;
        }

        //delete utdo
        if (event.getCode().equals(KeyCode.DELETE)) {
            btn_del.fire();
            return;
        }

        //botao d +
        if (event.getCode().equals(KeyCode.ADD)) {
            btn_add.fire();
            return;
        }

        //botao d -
        if (event.getCode().equals(KeyCode.MINUS)|| event.getCode().equals(KeyCode.SUBTRACT)) {
            btn_minus.fire();
            return;
        }

        //botao igual =
        if (event.getCode().equals(KeyCode.EQUALS)) {
            btn_equals.fire();
            return;
        }

        //botao d multiplica *
        if (event.getCode().equals(KeyCode.MULTIPLY)) {
            btn_mult.fire();
            return;
        }

        //botao d dividi /
        if (event.getCode().equals(KeyCode.DIVIDE)) {
            btn_divide.fire();
            return;
        }

        //número ponto
        if (event.getCode().equals(KeyCode.DECIMAL) ||
                event.getCode().equals(KeyCode.UNDEFINED) ||
                event.getCode().equals(KeyCode.COMMA) ||
                event.getCode().equals(KeyCode.PERIOD)) {
            btn_dot.fire();
            return;
        }

    }
}
