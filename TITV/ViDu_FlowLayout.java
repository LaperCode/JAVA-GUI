package TITV;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.FlowLayout;

public class ViDu_FlowLayout extends JFrame {
    public ViDu_FlowLayout() {
        this.setTitle("ViDu_FlowLayout");
        this.setSize(600, 400);
        // Căn giữa cửa sổ chương trình
        this.setLocationRelativeTo(null);
        
        // Set Layout
        //FlowLayout flo1 = new FlowLayout(); 
        //FlowLayout flo2 = new FlowLayout(FlowLayout.RIGHT); 
        FlowLayout flo3 = new FlowLayout(FlowLayout.CENTER, 50, 50); // hgap: khoảng cách giữa các phần tử
                                                                               // vgap: khoảng cách giữa các hàng line   
        this.setLayout(flo3);
    
        JButton jb1 = new JButton("1");
        JButton jb2 = new JButton("2");
        JButton jb3 = new JButton("3");
        
        // Add thành phần
        this.add(jb1);
        this.add(jb2);
        this.add(jb3);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ViDu_FlowLayout();
    }
}
