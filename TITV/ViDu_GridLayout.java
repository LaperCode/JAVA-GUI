package TITV;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.GridLayout;

public class ViDu_GridLayout extends JFrame {
    public ViDu_GridLayout() {
        this.setTitle("ViDu_GridLayout");
        this.setSize(600, 400);
        // Căn giữa cửa sổ chương trình
        this.setLocationRelativeTo(null);
        
        // Set Layout
        // GridLayout glo1 = new GridLayout(); 
        //GridLayout glo2 = new GridLayout(2, 5); 
        GridLayout glo3 = new GridLayout(2, 5, 25, 25); // hgap: khoảng cách giữa các phần tử
                                                                            // vgap: khoảng cách giữa các hàng line   
        this.setLayout(glo3);
    
        // JButton jb1 = new JButton("1");
        // JButton jb2 = new JButton("2");
        // JButton jb3 = new JButton("3");
        
        for(int i=0; i<10; i++) {
            JButton jb = new JButton(i+"");
            this.add(jb);
        }

        // Add thành phần
        // this.add(jb1);
        // this.add(jb2);
        // this.add(jb3);
    
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new ViDu_GridLayout();
    }
}
