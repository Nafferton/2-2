package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SceneController {

    @FXML
    private Label historyLabel;
    @FXML
    private Label resultLabel;

    private double firstOperand = 0;
    private String operator = "";
    private boolean startNewInput = true;

    @FXML
    public void handleDigit(ActionEvent event) {
        String digit = ((Button) event.getSource()).getText();

        if (startNewInput) {
            resultLabel.setText(digit.equals(".") ? "0." : digit);
            startNewInput = false;
        } else {

            if (digit.equals(".") && resultLabel.getText().contains(".")) {
                return;
            }
            resultLabel.setText(resultLabel.getText() + digit);
        }
    }

    @FXML
    public void handleOperator(ActionEvent event) {
        String newOperator = ((Button) event.getSource()).getText();

        // 1. If we already have an operator pending, and the user typed a new number, calculate it now!
        if (!operator.isEmpty() && !startNewInput) {
            double secondOperand = Double.parseDouble(resultLabel.getText());
            

            if (operator.equals("÷") && secondOperand == 0) {
                resultLabel.setText("Error");
                operator = "";
                startNewInput = true;
                return;
            }
            
            firstOperand = calculate(firstOperand, secondOperand, operator);
            resultLabel.setText(formatNumber(firstOperand));
            
            historyLabel.setText(formatNumber(firstOperand) + " " + newOperator);
            
        } else if (startNewInput && !operator.isEmpty()) {
            
        	String currentHistory = historyLabel.getText();
        	if(currentHistory.length() > 0) {
        		historyLabel.setText(currentHistory.substring(0, currentHistory.length() - 1) + newOperator);
        	
        	}
//            operator = newOperator;
//            historyLabel.setText(formatNumber(firstOperand) + " " + operator);
//            return;
            
        } else {
            firstOperand = Double.parseDouble(resultLabel.getText());
            historyLabel.setText(formatNumber(firstOperand) + " " + newOperator);
        }

        operator = newOperator;
//        historyLabel.setText(formatNumber(firstOperand) + " " + operator);
        startNewInput = true;
    }

    @FXML
    public void handleEquals(ActionEvent event) {
        if (operator.isEmpty() || startNewInput) return;

        double secondOperand = Double.parseDouble(resultLabel.getText());
        

        if (operator.equals("÷") && secondOperand == 0) {
            resultLabel.setText("Error");
            operator = "";
            startNewInput = true;
            return;
        }

        double result = calculate(firstOperand, secondOperand, operator);

        historyLabel.setText(historyLabel.getText() + " " + formatNumber(secondOperand) + " = " + formatNumber(result));
        resultLabel.setText(formatNumber(result));
        
        operator = "";
        startNewInput = true;
    }


    private double calculate(double num1, double num2, String op) {
        switch (op) {
            case "+": return num1 + num2;
            case "-": return num1 - num2;
            case "×": return num1 * num2;
            case "÷": return num1 / num2;
            default: return num2;
        }
    }

    @FXML
    public void handleAC(ActionEvent event) {
        resultLabel.setText("0");
        historyLabel.setText("");
        firstOperand = 0;
        operator = "";
        startNewInput = true;
    }

    @FXML
    public void handleBackspace(ActionEvent event) {
        if (startNewInput) return;
        
        String currentText = resultLabel.getText();
        if (currentText.length() > 1) {
            resultLabel.setText(currentText.substring(0, currentText.length() - 1));
        } else {
            resultLabel.setText("0");
            startNewInput = true;
        }
    }

    @FXML
    public void handleToggleSign(ActionEvent event) {
        double currentVal = Double.parseDouble(resultLabel.getText());
        currentVal = currentVal * -1;
        resultLabel.setText(formatNumber(currentVal));
    }

    @FXML
    public void handlePercentage(ActionEvent event) {
        double currentVal = Double.parseDouble(resultLabel.getText());
        currentVal = currentVal / 100;
        resultLabel.setText(formatNumber(currentVal));
        startNewInput = true;
    }

    private String formatNumber(double number) {
        if (number == (long) number) {
            return String.format("%d", (long) number);
        } else {
            return String.format("%s", number);
        }
    }
}