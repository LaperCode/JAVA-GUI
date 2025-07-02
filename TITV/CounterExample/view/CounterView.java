package TITV.CounterExample.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.event.ActionListener;

import TITV.CounterExample.controller.CounterListener;
import TITV.CounterExample.model.CounterModel;

public class CounterView extends JFrame {
    private CounterModel counterModel;
    
    private JButton jButton_up;
    private JButton jButton_down;
    private JLabel jLabel_value; // để xuất nd ra màn hình
    
    public CounterView() {
        this.counterModel = new CounterModel();
        this.init();
        this.setVisible(true);
    }

    public void init() {
        this.setTitle("Counter");
        this.setSize(300, 300);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        ActionListener ac = new CounterListener(this); // this là counter hiện tại ta đang làm việc

        jButton_up = new JButton("UP");
        jButton_up.addActionListener(ac);
        jButton_down = new JButton("DOWN");
        jButton_down.addActionListener(ac);
        jLabel_value = new JLabel(this.counterModel.getValue()+"", JLabel.CENTER);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(new BorderLayout());
        jPanel.add(jButton_up, BorderLayout.WEST);
        jPanel.add(jLabel_value, BorderLayout.CENTER);
        jPanel.add(jButton_down, BorderLayout.EAST);

        this.setLayout(new BorderLayout());
        this.add(jPanel, BorderLayout.CENTER);
    }

    public void increment() {
        this.counterModel.increment();
        this.jLabel_value.setText(this.counterModel.getValue()+""); // Mỗi lần value trong label thay đổi thì phải setText lại
    }

    public void decrement() {
        this.counterModel.decrement();
        this.jLabel_value.setText(this.counterModel.getValue()+"");
    }

    public static void main(String[] args) {
        CounterView ctv = new CounterView();
        // ctv.setVisible(true);
        // ctv.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // ctv.setLocationRelativeTo(null);
        // ctv.setSize(300, 300);
        // ctv.setTitle("Counter");
    }
}
