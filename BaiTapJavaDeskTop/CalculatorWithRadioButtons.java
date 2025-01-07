package BaiTapJavaDeskTop;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorWithRadioButtons extends JFrame {
    private JTextField txtNumber1, txtNumber2, txtResult;
    private JRadioButton rbtnSum, rbtnSubtract, rbtnMultiply, rbtnDivide;
    private JButton btnCalculate;

    public CalculatorWithRadioButtons() {
        // Thiết lập JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Calculator with Radio Buttons");
        this.setLayout(new GridLayout(6, 2, 10, 10));

        // Các thành phần giao diện
        JLabel lblNumber1 = new JLabel("Enter number 1:");
        txtNumber1 = new JTextField();
        JLabel lblNumber2 = new JLabel("Enter number 2:");
        txtNumber2 = new JTextField();
        JLabel lblResult = new JLabel("Result:");
        txtResult = new JTextField();
        txtResult.setEditable(false);

        // Radio buttons
        rbtnSum = new JRadioButton("Sum");
        rbtnSubtract = new JRadioButton("Subtract");
        rbtnMultiply = new JRadioButton("Multiply");
        rbtnDivide = new JRadioButton("Divide");

        // Group radio buttons
        // Giúp cho việc chỉ chọn 1 button mà ko chọn cùng lúc
        ButtonGroup group = new ButtonGroup();
        group.add(rbtnSum);
        group.add(rbtnSubtract);
        group.add(rbtnMultiply);
        group.add(rbtnDivide);

        // Button calculate
        btnCalculate = new JButton("Calculate");

        // Thêm các thành phần vào JFrame
        this.add(lblNumber1);
        this.add(txtNumber1);
        this.add(lblNumber2);
        this.add(txtNumber2);
        this.add(lblResult);
        this.add(txtResult);

        this.add(rbtnSum);
        this.add(rbtnSubtract);
        this.add(rbtnMultiply);
        this.add(rbtnDivide);
        this.add(btnCalculate);

        // Thêm sự kiện cho nút calculate
        btnCalculate.addActionListener(new RadioActionListener());
    }

    private class RadioActionListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                double num1 = Double.parseDouble(txtNumber1.getText());
                double num2 = Double.parseDouble(txtNumber2.getText());
                double result = 0;

                if (rbtnSum.isSelected()) {
                    result = num1 + num2;
                } else if (rbtnSubtract.isSelected()) {
                    result = num1 - num2;
                } else if (rbtnMultiply.isSelected()) {
                    result = num1 * num2;
                } else if (rbtnDivide.isSelected()) {
                    if (num2 != 0) {
                        result = num1 / num2;
                    } else {
                        JOptionPane.showMessageDialog(null, "Cannot divide by zero");
                        return;
                    }
                }
                txtResult.setText(String.valueOf(result));
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "Invalid input! Please enter numbers.");
            }
        }
    }

    public static void main(String[] args) {
        new CalculatorWithRadioButtons().setVisible(true);
    }
}
