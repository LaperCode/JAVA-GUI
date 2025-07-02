package TITV.MouseExample.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import TITV.MouseExample.controller.MouseExampleController;
import TITV.MouseExample.model.MouseExampleModel;

public class MouseExampleView extends JFrame {
    private MouseExampleModel mouseExampleModel;
    private JLabel jLabel_position;
    private JLabel jLabel_x;
    private JLabel jLabel_y;
    private JLabel jLabel_count;
    private JLabel jLabel_count_value;
    private JLabel jLabel_empty_1;
    private JLabel jLabel_check_in;
    private JLabel jLabel_check_in_value;
    private JLabel jLabel_empty_2;
            
    public MouseExampleView() {
        this.mouseExampleModel = new MouseExampleModel();
        this.init();
    }
            
    public void init() {
        this.setTitle("Mouse Example");
        this.setSize(600,600);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        MouseExampleController mouseExampleController = new MouseExampleController(this);
            
        JPanel jPanel_mouse = new JPanel();
        jPanel_mouse.setBackground(Color.CYAN);
        jPanel_mouse.addMouseListener(mouseExampleController);
        jPanel_mouse.addMouseMotionListener(mouseExampleController);
            
        JPanel jPanel_info = new JPanel();
        jPanel_info.setLayout(new GridLayout(3,3));

        Font f = new Font("Arial", Font.BOLD, 20);
            
        jLabel_position = new JLabel("Position: ");
        jLabel_position.setFont(f);
        jLabel_x = new JLabel("X = ");
        jLabel_x.setFont(f);
        jLabel_y = new JLabel("Y = ");
        jLabel_y.setFont(f);
        jLabel_count = new JLabel("Number of clicks: ");
        jLabel_count.setFont(f);
        jLabel_count_value = new JLabel();
        jLabel_count_value.setFont(f);
        jLabel_empty_1 = new JLabel();
        jLabel_check_in = new JLabel("Mouse is in component: ");
        jLabel_check_in.setFont(f);
        jLabel_check_in_value = new JLabel("no");
        jLabel_check_in_value.setFont(f);
        jLabel_empty_2 = new JLabel();

        jPanel_info.add(jLabel_position);
        jPanel_info.add(jLabel_x);
        jPanel_info.add(jLabel_y);
        jPanel_info.add(jLabel_count);
        jPanel_info.add(jLabel_count_value);
        jPanel_info.add(jLabel_empty_1);
        jPanel_info.add(jLabel_check_in);
        jPanel_info.add(jLabel_check_in_value);
        jPanel_info.add(jLabel_empty_2);

        this.setLayout(new BorderLayout());
        this.add(jPanel_mouse, BorderLayout.CENTER);
        this.add(jPanel_info, BorderLayout.SOUTH);


        this.setVisible(true);
    }

    public void click() {
        this.mouseExampleModel.addClick();
        this.jLabel_count_value.setText(this.mouseExampleModel.getCount()+"");
    }

    public void enter() {
        this.mouseExampleModel.enter();
        this.jLabel_check_in_value.setText(this.mouseExampleModel.getCheckIn());
    }

    public void exit() {
        this.mouseExampleModel.exit();
        this.jLabel_check_in_value.setText(this.mouseExampleModel.getCheckIn());
    }

    public void update(int x, int y) {
        this.mouseExampleModel.setX(x);
        this.mouseExampleModel.setY(y);
        this.jLabel_x.setText(this.mouseExampleModel.getX()+"");
        this.jLabel_y.setText(this.mouseExampleModel.getY()+"");
    }
}
