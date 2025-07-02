import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
// import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.util.InputMismatchException;


public class Bai5 extends JFrame {
    private JTextField txtNumber, txtResult;

    public Bai5() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Kiểm tra số nguyên tố");
        this.setVisible(true);
        this.setSize(400, 300);
        this.setLocationRelativeTo(null);

        // Panel1
        JPanel panel = new JPanel(new GridLayout(2, 2, 10, 10));
        panel.setBorder(new EmptyBorder(20, 20, 20, 20));

        JLabel lblNumber = new JLabel("Nhập số tự nhiên n: ");
        lblNumber.setBackground(Color.YELLOW);
        lblNumber.setOpaque(true);
        txtNumber = new JTextField();
        txtNumber.setPreferredSize(new Dimension(100, 1));

        JLabel lblResult = new JLabel("Kết quả: ");
        lblResult.setBackground(Color.MAGENTA);
        lblResult.setOpaque(true);
        txtResult = new JTextField();
        txtResult.setPreferredSize(new Dimension(200, 25));

        txtResult.setEditable(false);
        

        panel.add(lblNumber);
        panel.add(txtNumber);
        panel.add(lblResult);
        panel.add(txtResult);

        //Panel2
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton button = new JButton("Kiểm tra");
        panelButton.add(button);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent a) {
                try {
                    String numberStr = txtNumber.getText().trim();
                    if(numberStr.isEmpty()) throw new IllegalArgumentException("Không được để trống chỗ nhập!");

                    int number = Integer.parseInt(numberStr);
                    if(isPrime(number)) {
                        txtResult.setText(numberStr+" là số nguyên tố");
                        // JOptionPane.showMessageDialog(null, numberStr + " là số nguyên tố");
                    } else {
                        txtResult.setText(numberStr+" không phải là số nguyên tố");
                    }
                } catch (NumberFormatException e1) {
                    txtResult.setText("X");
                    JOptionPane.showMessageDialog(null, "Vui lòng nhập một số nguyên", "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                } catch (IllegalArgumentException e2) {
                    txtResult.setText("X");
                    JOptionPane.showMessageDialog(null, e2.getMessage(), "Lỗi nhập liệu", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        final JButton endButton = new JButton("Click here to end program");
        endButton.setPreferredSize(new Dimension(250, 25));
        endButton.setBackground(Color.RED);
        endButton.setForeground(Color.WHITE);
        endButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (e.getSource() == endButton) {
                    System.exit(0);
                }
            }
        });
        JPanel panelEnd = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelEnd.add(endButton);
        panelEnd.setBackground(Color.ORANGE);
        
        this.setLayout(new BorderLayout(10, 10));
        this.add(panel, BorderLayout.NORTH);
        this.add(panelButton, BorderLayout.CENTER);
        this.add(panelEnd, BorderLayout.SOUTH);
        this.setBackground(Color.ORANGE);
        
    }

    private boolean isPrime(int n) {
        if(n<2) return false;
        for(int i=2; i <= Math.sqrt(n); i++) {
            if(n%i==0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai5());
    }
}
