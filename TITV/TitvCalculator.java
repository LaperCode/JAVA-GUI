package TITV;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
//

public class TitvCalculator extends JFrame {
    public TitvCalculator() {
        this.setTitle("Titv Calculator");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);

        //
        JTextField jTextField = new JTextField(50);
        JPanel jPanel_head = new JPanel();
        jPanel_head.setLayout(new BorderLayout());
        jPanel_head.add(jTextField, BorderLayout.CENTER);
    JPanel p = new JPanel();
    p.setLayout(new BorderLayout());
    p.add(new Button("Reset"), BorderLayout.WEST);

        JButton jButton_0 = new JButton("0");
        JButton jButton_1 = new JButton("1");
        JButton jButton_2 = new JButton("2");
        JButton jButton_3 = new JButton("3");
        JButton jButton_4 = new JButton("4");
        JButton jButton_5 = new JButton("5");
        JButton jButton_6 = new JButton("6");
        JButton jButton_7 = new JButton("7");
        JButton jButton_8 = new JButton("8");
        JButton jButton_9 = new JButton("9");
        JButton jButton_cong = new JButton("+");
        JButton jButton_tru = new JButton("-");
        JButton jButton_nhan = new JButton("*");
        JButton jButton_chia = new JButton("/");
        JButton jButton_bang = new JButton("=");
        JPanel jPanel_buttons = new JPanel();
        jPanel_buttons.setLayout(new GridLayout(5, 3));
        jPanel_buttons.add(jButton_0);
        jPanel_buttons.add(jButton_1);
        jPanel_buttons.add(jButton_2);
        jPanel_buttons.add(jButton_3);
        jPanel_buttons.add(jButton_4);
        jPanel_buttons.add(jButton_5);
        jPanel_buttons.add(jButton_6);
        jPanel_buttons.add(jButton_7);
        jPanel_buttons.add(jButton_8);
        jPanel_buttons.add(jButton_9);
        jPanel_buttons.add(jButton_cong);
        jPanel_buttons.add(jButton_tru);
        jPanel_buttons.add(jButton_nhan);
        jPanel_buttons.add(jButton_chia);
        jPanel_buttons.add(jButton_bang);

        // Set Frame và add 2 Panel vào Frame
        this.setLayout(new BorderLayout());
        this.add(jPanel_head, BorderLayout.NORTH);
        this.add(jPanel_buttons, BorderLayout.CENTER);
        this.add(p, BorderLayout.SOUTH);
        
        // this.add(jTextField);
        // this.add(jButton_0);
        // this.add(jButton_1);
        // this.add(jButton_2);
        // this.add(jButton_3);
        // this.add(jButton_4);
        // this.add(jButton_5);
        // this.add(jButton_6);
        // this.add(jButton_7);
        // this.add(jButton_8);
        // this.add(jButton_9);
        // this.add(jButton_cong);
        // this.add(jButton_tru);
        // this.add(jButton_nhan);
        // this.add(jButton_chia);
        // this.add(jButton_bang);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        try {
            // com.sun.java.swing.plaf.gtk.GTKLookAndFeel
            // com.sun.java.swing.plaf.motif.MotifLookAndFeel
            // com.sun.java.swing.plaf.gtk.GTKLookAndFeel
            // UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
            new TitvCalculator();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
