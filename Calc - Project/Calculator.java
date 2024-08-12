import java.awt.*;
import java.awt.event.*;

public class Calculator extends Frame implements ActionListener {
    Button zero, one, two, three, four, five, six, seven, eight, nine, add, sub, mult, div, equal, clr, off;
    TextField display;
    String operator;
    double num1, num2, result;

    Calculator() {
        display = new TextField("0");
        display.setFocusable(false);
        display.setBounds(40, 40, 220, 35);
        add(display);

        // NUMBERS
        one = new Button("1");
        one.setBounds(50, 130, 35, 35);
        one.addActionListener(this);
        one.setFocusable(false);
        add(one);

        two = new Button("2");
        two.setBounds(105, 130, 35, 35);
        two.addActionListener(this);
	  two.setFocusable(false);
        add(two);

        three = new Button("3");
        three.setBounds(160, 130, 35, 35);
        three.addActionListener(this);
		three.setFocusable(false);
        add(three);

        four = new Button("4");
        four.setBounds(50, 185, 35, 35);
        four.addActionListener(this);
		four.setFocusable(false);
        add(four);

        five = new Button("5");
        five.setBounds(105, 185, 35, 35);
        five.addActionListener(this);
		five.setFocusable(false);
        add(five);

        six = new Button("6");
        six.setBounds(160, 185, 35, 35);
        six.addActionListener(this);
		six.setFocusable(false);
        add(six);

        seven = new Button("7");
        seven.setBounds(50, 240, 35, 35);
        seven.addActionListener(this);
		seven.setFocusable(false);
        add(seven);

        eight = new Button("8");
        eight.setBounds(105, 240, 35, 35);
        eight.addActionListener(this);
		eight.setFocusable(false);
        add(eight);

        nine = new Button("9");
        nine.setBounds(160, 240, 35, 35);
        nine.addActionListener(this);
		nine.setFocusable(false);
        add(nine);

        zero = new Button("0");
        zero.setBounds(50, 295, 35, 35);
        zero.addActionListener(this);
		zero.setFocusable(false);
        add(zero);

        // ACTIONS
        off = new Button("Off");
        off.setBounds(50, 80, 35, 35);
		off.setFocusable(false);
        off.addActionListener(e -> System.exit(0));
        add(off);

        clr = new Button("C");
        clr.setBounds(105, 80, 90, 35);
		clr.setFocusable(false);
        clr.addActionListener(e -> {
            display.setText("0");
            operator = "";
            num1 = num2 = result = 0;
        });
        add(clr);

        div = new Button("/");
        div.setBounds(215, 80, 35, 35);
        div.addActionListener(this);
		div.setFocusable(false);
        add(div);

        mult = new Button("*");
        mult.setBounds(215, 130, 35, 35);
        mult.addActionListener(this);
		mult.setFocusable(false);
        add(mult);

        sub = new Button("-");
        sub.setBounds(215, 185, 35, 35);
        sub.addActionListener(this);
		sub.setFocusable(false);
        add(sub);

        add = new Button("+");
        add.setBounds(215, 240, 35, 90);
        add.addActionListener(this);
		add.setFocusable(false);
        add(add);

        equal = new Button("=");
        equal.setBounds(105, 295, 90, 35);
        equal.addActionListener(this);
		equal.setFocusable(false);
        add(equal);

        setTitle("Calculator");
        setSize(300, 350);
        setLayout(null);
        setVisible(true);

        // Initialize variables
        operator = "";
        num1 = 0;
        num2 = 0;
        result = 0;
    }

    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();

        if (command.charAt(0) >= '0' && command.charAt(0) <= '9') {
            if (display.getText().equals("0")) {
                display.setText(command);
            } else {
                display.setText(display.getText() + command);
            }
        } else if (command.equals("C")) {
            display.setText("0");
            operator = "";
            num1 = num2 = result = 0;
        } else if (command.equals("=")) {
            num2 = Double.parseDouble(display.getText());
            switch (operator) {
                case "+":
                    result = num1 + num2;
                    break;
                case "-":
                    result = num1 - num2;
                    break;
                case "*":
                    result = num1 * num2;
                    break;
                case "/":
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        display.setText("Error");
                        return;
                    }
                    break;
            }
            display.setText(String.valueOf(result));
            operator = "";
        } else {
            if (display.getText().isEmpty()) {
                return; // Prevent operator input if no number is entered
            }
            if (operator.isEmpty()) {
                operator = command;
                num1 = Double.parseDouble(display.getText());
                display.setText("");
            }
        }
    }

    public static void main(String args[]) {
        new Calculator();
    }
}