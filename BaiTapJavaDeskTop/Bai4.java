import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class Bai4 extends JFrame {
    private JTextField txtSoTuNhien, txtResult;
    
    public Bai4() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400, 200);
        this.setTitle("Kiểm tra số tự nhiên n là số chẵn hay số lẻ ?");
        this.setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(new EmptyBorder(10, 10, 10, 10));

        JLabel lblSoTuNhien = new JLabel("Nhập số tự nhiên n: ");
        txtSoTuNhien = new JTextField();

        JLabel lblResult = new JLabel("Kết quả: ");
        txtResult = new JTextField();
        txtResult.setEditable(false); //kq chỉ đọc
        
        txtSoTuNhien.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    int n = Integer.parseInt(txtSoTuNhien.getText().trim());
                    if(n%2==0) {
                        txtResult.setText(n+" là số chẵn.");
                    }
                    else {
                        txtResult.setText(n+" là số lẻ.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Vui lòng nhập một số hợp lệ!");
                }
            }
        });

        panel.add(lblSoTuNhien);
        panel.add(txtSoTuNhien);
        panel.add(lblResult);
        panel.add(txtResult);

        this.add(panel);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        new Bai4();
    }
}
