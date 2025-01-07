package TITV;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JFrame;

public class ViDu_BorderLayout extends JFrame {
    public ViDu_BorderLayout() {
        this.setTitle("ViDu_BorderLayout");
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);

        //Set Layout
        // BorderLayout blo1 = new BorderLayout();
        BorderLayout blo2 = new BorderLayout(15,15);

        this.setLayout(blo2);

        JButton jb1 = new JButton("1");
        JButton jb2 = new JButton("2");
        JButton jb3 = new JButton("3");
        JButton jb4 = new JButton("4");
        JButton jb5 = new JButton("5");

        // add thành phần
        this.add(jb1, BorderLayout.NORTH);
        this.add(jb2, BorderLayout.SOUTH);
        this.add(jb3, BorderLayout.WEST);
        this.add(jb4, BorderLayout.EAST);
        this.add(jb5, BorderLayout.CENTER);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ViDu_BorderLayout();
    }
}
