import javax.swing.*;
import java.awt.*;

/*
GOAL:
    This java project was made to replicate a working business calculator.
    This does not have any feature of a scientific calculator.
*/

public class Calculator extends JFrame {

    //important variables

    static JTextField display;
    static JPanel buttonPanel;
    static double firstNumber;
    static String operator;
    static boolean startingNewNumber = true;

    public static void main(String[] args) {
        new Calculator();
    }

    //gui for calculator

    Calculator() {

        //display

        display = new JTextField("0");
        display.setEditable(false);
        add(display).setBounds(20, 20, 260, 40);

        //button panel and buttons

        buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(4, 4));

        JButton btn7 = new JButton("7");
        btn7.addActionListener(e -> pressDigit(btn7.getText()));
        buttonPanel.add(btn7);
        JButton btn8 = new JButton("8");
        btn8.addActionListener(e -> pressDigit(btn8.getText()));
        buttonPanel.add(btn8);
        JButton btn9 = new JButton("9");
        btn9.addActionListener(e -> pressDigit(btn9.getText()));
        buttonPanel.add(btn9);
        JButton btnDiv = new JButton("/");
        btnDiv.addActionListener(e -> pressOperator(btnDiv.getText()));
        buttonPanel.add(btnDiv);

        JButton btn4 = new JButton("4");
        btn4.addActionListener(e -> pressDigit(btn4.getText()));
        buttonPanel.add(btn4);
        JButton btn5 = new JButton("5");
        btn5.addActionListener(e -> pressDigit(btn5.getText()));
        buttonPanel.add(btn5);
        JButton btn6 = new JButton("6");
        btn6.addActionListener(e -> pressDigit(btn6.getText()));
        buttonPanel.add(btn6);
        JButton btnMul = new JButton("*");
        btnMul.addActionListener(e -> pressOperator(btnMul.getText()));
        buttonPanel.add(btnMul);

        JButton btn1 = new JButton("1");
        btn1.addActionListener(e -> pressDigit(btn1.getText()));
        buttonPanel.add(btn1);
        JButton btn2 = new JButton("2");
        btn2.addActionListener(e -> pressDigit(btn2.getText()));
        buttonPanel.add(btn2);
        JButton btn3 = new JButton("3");
        btn3.addActionListener(e -> pressDigit(btn3.getText()));
        buttonPanel.add(btn3);
        JButton btnSub = new JButton("-");
        btnSub.addActionListener(e -> pressOperator(btnSub.getText()));
        buttonPanel.add(btnSub);

        JButton btn0 = new JButton("0");
        btn0.addActionListener(e -> pressDigit(btn0.getText()));
        buttonPanel.add(btn0);
        JButton btnC = new JButton("C");
        btnC.addActionListener(e -> { clearDisplay(); });
        buttonPanel.add(btnC);
        JButton btnEq = new JButton("=");
        btnEq.addActionListener(e -> pressEqual());
        buttonPanel.add(btnEq);
        JButton btnAdd = new JButton("+");
        btnAdd.addActionListener(e -> pressOperator(btnAdd.getText()));
        buttonPanel.add(btnAdd);

        add(buttonPanel).setBounds(20, 70, 260, 280);

        //frame settings

        setLayout(null);
        setTitle("Calculator");
        setSize(300, 400);
        setVisible(true);
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    //saves first number and operator, shows operator on display

    private static void pressOperator(String op) {
        try {
            firstNumber = Double.parseDouble(display.getText());
            operator = op;
            display.setText(op);
            startingNewNumber = true;
        } catch (NumberFormatException ex) {
            clearDisplay();
        }
    }

    //appends digit or sets display if starting new number

    private static void pressDigit(String d) {
        if (startingNewNumber)
            display.setText(d);
        else
            display.setText(display.getText() + d);
        startingNewNumber = false;
    }

    //computes firstNumber op secondNumber, shows result or error for divide by zero

    private static void pressEqual() {
        try {
            double secondNumber = Double.parseDouble(display.getText());
            String op = operator;
            double result;
            if (op == null) {
                result = secondNumber;
            } else if (op.equals("+")) {
                result = firstNumber + secondNumber;
            } else if (op.equals("-")) {
                result = firstNumber - secondNumber;
            } else if (op.equals("*")) {
                result = firstNumber * secondNumber;
            } else if (op.equals("/")) {
                if (secondNumber == 0) {
                    display.setText("Syntax Error");
                    startingNewNumber = true;
                    return;
                }
                result = firstNumber / secondNumber;
            } else {
                result = secondNumber;
            }
            display.setText(String.valueOf(result));
            startingNewNumber = true;
        } catch (NumberFormatException ex) {
            clearDisplay();
        }
    }

    //resets display and state

    private static void clearDisplay() {
        display.setText("0");
        firstNumber = 0;
        operator = null;
        startingNewNumber = true;
    }
}
