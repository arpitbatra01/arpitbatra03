import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class CalculatorApp extends JFrame implements ActionListener {

private JTextField textField;
private JButton[] numberButtons;
private JButton[] operatorButtons;
private JButton equalsButton, clearButton;
private JPanel panel;

private double num1 = 0, num2 = 0, result = 0;
private char operator;

public CalculatorApp() {
setTitle("Calculator");
setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
setSize(300, 400);
setResizable(false);

textField = new JTextField();
textField.setPreferredSize(new Dimension(300, 50));
textField.setFont(new Font("Arial", Font.PLAIN, 24));
textField.setHorizontalAlignment(JTextField.RIGHT);
textField.setEditable(false);

numberButtons = new JButton[10];
for (int i = 0; i < 10; i++) {
numberButtons[i] = new JButton(String.valueof(i));
numberButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
numberButtons[i].addActionListener(this);
}

operatorButtons = new JButton[5];
String[] operators = {"+", "-", "*" ,"/", "="};
for (int i = 0; i < 5; i++) {
operatorButtons[i] = new JButton(operators[i]);
operatorButtons[i].setFont(new Font("Arial", Font.PLAIN, 18));
operatorButtons[i].addActionListener(this);
}

equalsButton = new JButton("=");
equalsButton.setFont(new Font("Arial", Font.PLAIN, 18));
equalsButton.addActionListener(this);

clearButton = new JButton("C");
clearButton.setFont(new Font("Arial", Font.PLAIN, 18));
clearButton.addActionListener(this);

panel = new JPanel();
panel.setLayout(new GridLayout(5, 4, 10, 10));
panel.add(textField);
panel.add(clearButton);
for (int i = 7; i <= 9; i++) panel.add(numberButtons[i]);
panel.add(operatorButtons[0]);
for (int i = 4; i <= 6; i++) panel.add(numberButtons[i]);
panel.add(operatorButtons[1]);
for (int i = 1; i <= 3; i++) panel.add(numberButtons[i]);
panel.add(operatorButtons[2]);
panel.add(numberButtons[0]);
panel.add(operatorButtons[3]);
panel.add(operatorButtons[4]);

add(panel);
setVisible(true);
}

@Override
public void actionPerformed(ActionEvent e) {
for (int i = 0; i < 10; i++) {
if (e.getSource() == numberButtons[i]) {
textField.setText(textField.getText() + i);
}
}

if (e.getSource() == operatorButtons[0]) {
num1 = Double.parseDouble(textField.getText());
operator = '+';
textField.setText("");
}

if (e.getSource() == operatorButtons[1]) {
num1 = Double.parseDouble(textField.getText());
operator = '-';
textField.setText("");
}

if (e.getSource() == operatorButtons[2]) {
num1 = Double.parseDouble(textField.getText());
operator = '*';
textField.setText("");
}

if (e.getSource() == operatorButtons[3]) {
num1 = Double.parseDouble(textField.getText());
operator = '/';
textField.setText("");
}

if (e.getSource() == equalsButton) {
num2 = Double.parseDouble(textField.getText());

switch (operator) {
case '+':
result = num1 + num2;
break;
case '-':
result = num1 - num2;
break;
case '*':
result = num1 * num2;
break;
case '/':
if (num2 != 0) {
result = num1 / num2;
} else {
textField.setText("Error");
return;
}
break;
}

textField.setText(String.valueOf(result));
num1 = result;
}

if (e.getSource() == clearButton) {
textField.setText("");
num1 = num2 = result = 0;
operator = '\0';
}
}
public static void main(String[] args) {
new CalculatorApp();
}
}
// program created by arpitbatra01
