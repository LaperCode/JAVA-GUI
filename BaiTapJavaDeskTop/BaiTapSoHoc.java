import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BaiTapSoHoc extends JFrame {
    private JTextField txt1, txt2, txt3;

    public BaiTapSoHoc() {
        this.setTitle("Bài tập số học giữa 2 số");
        this.setSize(500, 350);
        this.setLayout(new BorderLayout());
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Font
        Font myfFont = new Font("Arial", Font.BOLD, 20);
        
        //Panel
        JPanel p0 = new JPanel(new FlowLayout());
        JPanel p1 = new JPanel(new GridLayout(3, 2, 5, 5));
        JPanel p2 = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 5));

        //Các Label và radioButton và TextField
        JLabel jlabel_TieuDe = new JLabel("BTSH");
        jlabel_TieuDe.setFont(myfFont);
        jlabel_TieuDe.setForeground(Color.red);
        jlabel_TieuDe.setBackground(Color.GREEN);
        jlabel_TieuDe.setOpaque(true);
        p0.add(jlabel_TieuDe);
        p0.setBackground(Color.ORANGE);

        JLabel lbl1 = new JLabel("Nhập số 1: ");
        txt1 = new JTextField(50);
        JLabel lbl2 = new JLabel("Nhập số 2: ");
        txt2 = new JTextField(50);
        JLabel lbl3 = new JLabel("Kết quả = ");
        txt3 = new JTextField(50);
        txt3.setEditable(false);
        p1.add(lbl1);
        p1.add(txt1);
        p1.add(lbl2);
        p1.add(txt2);
        p1.add(lbl3);
        p1.add(txt3);
        p1.setBackground(Color.GREEN);

        ButtonGroup btngrp = new ButtonGroup();
        JRadioButton rdo1 = new JRadioButton("Tổng");
        JRadioButton rdo2 = new JRadioButton("Hiệu");
        JRadioButton rdo3 = new JRadioButton("Nhân");
        JRadioButton rdo4 = new JRadioButton("Chia");
        btngrp.add(rdo1);
        btngrp.add(rdo2);
        btngrp.add(rdo3);
        btngrp.add(rdo4);
        p2.add(rdo1);
        p2.add(rdo2);
        p2.add(rdo3);
        p2.add(rdo4);


        //Xử lý các sự kiện 4 nút
        rdo1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int txt_so1 = Integer.parseInt(txt1.getText().trim());
                    int txt_so2 = Integer.parseInt(txt2.getText().trim());
                    int kq = txt_so1+txt_so2;
                    txt3.setText(kq+"");
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu! Vui lòng nhập đúng dữ liệu số");
                }

            }
        });
        rdo2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int txt_so1 = Integer.parseInt(txt1.getText().trim());
                    int txt_so2 = Integer.parseInt(txt2.getText().trim());
                    int kq = txt_so1-txt_so2;
                    txt3.setText(kq+"");
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu! Vui lòng nhập đúng dữ liệu số");
                }

            }
        });
        rdo3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int txt_so1 = Integer.parseInt(txt1.getText().trim());
                    int txt_so2 = Integer.parseInt(txt2.getText().trim());
                    int kq = txt_so1*txt_so2;
                    txt3.setText(kq+"");
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu! Vui lòng nhập đúng dữ liệu số");
                }

            }
        });
        rdo4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    int txt_so1 = Integer.parseInt(txt1.getText().trim());
                    int txt_so2 = Integer.parseInt(txt2.getText().trim());
                    if(txt_so2==0) {
                        throw new IllegalArgumentException();
                    }
                    int kq = txt_so1/txt_so2;
                    txt3.setText(kq+"");
                } catch (NumberFormatException e1) {
                    JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu! Vui lòng nhập đúng dữ liệu số");
                } catch (IllegalArgumentException e1) {
                    JOptionPane.showMessageDialog(null, "Không thể chia cho 0!" );
                }

            }
        });

        // add 3 panel
        this.add(p0, BorderLayout.NORTH);
        this.add(p1, BorderLayout.CENTER);
        this.add(p2, BorderLayout.SOUTH);

        this.setVisible(true);
    }

    public static void main(String[] args) {
        new BaiTapSoHoc();
    }
}
