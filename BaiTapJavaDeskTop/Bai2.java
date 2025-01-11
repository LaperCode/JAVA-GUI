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

public class Bai2 extends JFrame {
    private JTextField txtDai, txtRong, txtDienTich, txtChuVi;
    
    public Bai2() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 300);
        this.setTitle("Tính diện tích và chu vi hình chữ nhật");
        this.setLocationRelativeTo(null);
        // this.setLayout(new GridLayout(5, 2));

        JPanel mainPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        mainPanel.setBorder(null);

        JLabel lblDai = new JLabel("Nhập chiều dài hình chữ nhật: ");
        txtDai = new JTextField();
        JLabel lblRong = new JLabel("Nhập chiều rộng hình chữ nhật: ");
        txtRong = new JTextField();
        JLabel lblDienTich = new JLabel("Diện tích hình chữ nhật = ");
        txtDienTich = new JTextField();
        txtDienTich.setEditable(false);
        JLabel lblChuVi = new JLabel("Chu vi hình chữ nhật = ");
        txtChuVi = new JTextField();
        txtChuVi.setEditable(false);

        // this.add(lblDai);
        // this.add(txtDai);
        // this.add(lblRong);
        // this.add(txtRong);
        // this.add(lblDienTich);
        // this.add(txtDienTich);
        // this.add(lblChuVi);
        // this.add(txtChuVi);
        mainPanel.add(lblDai);
        mainPanel.add(txtDai);
        mainPanel.add(lblRong);
        mainPanel.add(txtRong);
        mainPanel.add(lblDienTich);
        mainPanel.add(txtDienTich);
        mainPanel.add(lblChuVi);
        mainPanel.add(txtChuVi);

        // Nút để tính
        JPanel lblButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("Tính");
        lblButton.add(button);
        button.addActionListener(new ActionListener() {
            @Override
            public void  actionPerformed(ActionEvent e) {
                try {
                    String daiStr = txtDai.getText().trim();
                    String rongStr = txtRong.getText().trim();
                    if(daiStr.isEmpty() || rongStr.isEmpty()) {
                        throw new IllegalArgumentException("Không được để trống chỗ nhập!");
                    }
                    double dai = Double.parseDouble(txtDai.getText());
                    double rong = Double.parseDouble(txtRong.getText());
                    double dienTich = dai * rong;
                    double chuVi = 2 * (dai + rong);
                    txtDienTich.setText(String.valueOf(dienTich));
                    txtChuVi.setText(String.valueOf(chuVi));
                } catch (NumberFormatException ex) {
                    txtDienTich.setText("X");
                    txtChuVi.setText("X");
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập số hợp lệ!", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE); 
                } catch (IllegalArgumentException ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        this.setLayout(new BorderLayout());
        this.add(lblButton, BorderLayout.SOUTH);
        this.add(mainPanel, BorderLayout.CENTER);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai2();
    }
}
