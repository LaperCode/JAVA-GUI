import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Bai3 extends JFrame {
    private JTextField txtBanKinh, txtDienTich, txtChuVi;

    public Bai3() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 400);
        this.setTitle("Tính diện tích, chu vi hình tròn");
        this.setLocationRelativeTo(null);

        JPanel panel1 = new JPanel(new GridLayout(3,2,10,10));
        panel1.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblBanKinh = new JLabel("Nhập bán kính hình tròn: ");
        txtBanKinh = new JTextField();
        JLabel lblDienTich = new JLabel("Diện tích hình tròn = ");
        txtDienTich = new JTextField();
        txtDienTich.setEditable(false);
        JLabel lblChuVi = new JLabel("Chu vi hình tròn = ");
        txtChuVi = new JTextField();
        txtChuVi.setEditable(false);

        panel1.add(lblBanKinh);
        panel1.add(txtBanKinh);
        panel1.add(lblDienTich);
        panel1.add(txtDienTich);
        panel1.add(lblChuVi);
        panel1.add(txtChuVi);

        JPanel panel2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("Nhấn để tính diện tích và chu vi hình tròn");
        panel2.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String banKinhStr = txtBanKinh.getText().trim();
                    if(banKinhStr.isEmpty()) {
                        throw new IllegalArgumentException("Không được để trống!");
                    }

                    double banKinh = Double.parseDouble(txtBanKinh.getText());
                    double dienTich = Math.PI*Math.pow(banKinh, banKinh);
                    double chuVi = 2*Math.PI*banKinh;   

                    txtDienTich.setText(String.valueOf(dienTich));
                    txtChuVi.setText(String.valueOf(chuVi));
                } catch (NumberFormatException ex) {
                    txtDienTich.setText("X");
                    txtChuVi.setText("X");
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập lại!!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(),"Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        
        this.setLayout(new BorderLayout());
        this.add(panel1, BorderLayout.CENTER);
        this.add(panel2, BorderLayout.SOUTH);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai3();
    }
}
