package TITV;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator extends JFrame {
    public Calculator() {
        // Thiết lập JFrame
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        // Tạo JPanel với GridLayout 5 hàng, 4 cột
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(5, 4, 5, 5));

        // Các nút của máy tính
        String[] buttons = {
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+",
            "C", "±", "%", "√"
        };

        // Thêm các nút vào JPanel
        for(String txt : buttons) {
            JButton button = new JButton(txt);
            panel.add(button);
        }

        // Thêm JPanel vào JFrame
        this.add(panel);

        // this.setVisible(true);
    }

    public static void main(String[] args) {
        Calculator a = new Calculator();
        a.setVisible(true);
        // new Calculator();
    }
}
