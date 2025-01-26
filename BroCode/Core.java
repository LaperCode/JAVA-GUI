package BroCode;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Core {
    public static void main(String[] args) {
        //setLayout dành cho Frame và setBounds dành cho đối tượng bị add như panel, button, text,...
        JFrame frame = new JFrame("My frame");
        frame.setLayout(null);
        frame.setLocation(200, 100);
        frame.setSize(400, 160);

        JButton b1 = new JButton("Button 1");
        b1.setBounds(0, 0, 100, 25);
        frame.add(b1);
        JButton b2 = new JButton("Button 2");
        b2.setBounds(100,0,100,25);
        frame.add(b2);

        JLabel label = new JLabel("Hey");
        label.setBounds(10, 50, 100,30);
        label.setBackground(Color.BLUE); // set màu nền của panel hey
        label.setOpaque(true);
        frame.add(label);

        frame.getContentPane().setBackground(Color.red); // set màu nền cho cửa sổ chương trình

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
