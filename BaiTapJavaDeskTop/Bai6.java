import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

public class Bai6 extends JFrame {
    private JTextField txtNumber;
    private JTextArea txtOutput;

    public Bai6() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // this.setVisible(true);
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);

        //Layout
        JPanel panel = new JPanel(new BorderLayout());
        JPanel inputPanel = new JPanel(new FlowLayout());
        JPanel buttonPanel = new JPanel(new GridLayout(5, 1, 5, 5));
        txtNumber = new JTextField(10);
        txtOutput = new JTextArea();
        txtOutput.setEditable(false);
        txtOutput.setLineWrap(true);
        txtOutput.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(txtOutput);

        //Buttons
        JButton btnAllNumbers = new JButton("Tất cả các số và tổng: ");
        JButton btnEvenNumbers = new JButton("Số chẵn và tổng:");
        JButton btnOddNumbers = new JButton("Số lẻ và tổng:");
        JButton btnPrimeNumbers = new JButton("Số nguyên tố và tổng: ");
        JButton btnFirstNPrimes = new JButton("N số nguyên tố đầu tiên:");

        //Add components
        inputPanel.add(new JLabel("Nhập số n:"));
        inputPanel.add(txtNumber);
        buttonPanel.add(btnAllNumbers);
        buttonPanel.add(btnEvenNumbers);
        buttonPanel.add(btnOddNumbers);
        buttonPanel.add(btnPrimeNumbers);
        buttonPanel.add(btnFirstNPrimes);

        panel.add(inputPanel, BorderLayout.NORTH);
        panel.add(buttonPanel, BorderLayout.WEST);
        panel.add(scrollPane, BorderLayout.CENTER);

        this.add(panel);

        //Tính năng
        btnAllNumbers.addActionListener(_ -> displayAllNumbers());
        btnEvenNumbers.addActionListener(_ -> displayEvenNumbers());
        btnOddNumbers.addActionListener(_ -> displayOddNumbers());
        btnPrimeNumbers.addActionListener(_ -> displayPrimeNumbers());
        btnFirstNPrimes.addActionListener(_ -> displayFirstNPrimes());
    }

    private int getNhap() {
        try {
            String numberString = txtNumber.getText().trim();
            if(numberString.isEmpty()) throw new IllegalArgumentException("Không được để trống");
            int n = Integer.parseInt(txtNumber.getText().trim());
            if(n<0) {
                JOptionPane.showMessageDialog(this, "Cần nhập số tự nhiên n không âm!", "Lỗi", JOptionPane.ERROR_MESSAGE);
                return -1;
            }
            return n;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập một số nguyên hợp lệ!", "Lỗi", JOptionPane.ERROR_MESSAGE);
            return -1;
        } catch (IllegalArgumentException e) {
               JOptionPane.showMessageDialog(null, e.getMessage(), "Lỗi", JOptionPane.ERROR_MESSAGE);
            return -1;
        }
    }
    
    //Câu a
    private void displayAllNumbers() {
        int n = getNhap();
        if (n < 0)
            return;
        StringBuilder result = new StringBuilder("Các số tự nhiên <= " + n + ": ");
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            result.append(i + " ");
            sum += i;
        }
        result.append("\nTổng: " + sum);
        txtOutput.setText(result.toString());
    }

    //Câu b
    private void displayEvenNumbers() {
        int n = getNhap();
        if(n<0) return;
        StringBuilder result = new StringBuilder("Các số chẵn <= "+n+": ");
        int sum=0;
        for (int i = 2; i<=n; i+=2) {
            result.append(i+" ");
            sum+=i;
        }
        result.append("\nTổng: "+sum);
        txtOutput.setText(result.toString());
    }

    //Câu c
    private void displayOddNumbers() {
        int n = getNhap();
        if(n<0) return;
        StringBuilder result = new StringBuilder("Các số lẻ <= "+n+": ");
        int sum=0;
        for (int i = 1; i<=n; i+=2) {
            result.append(i+" ");
            sum+=i;
        }
        result.append("\nTổng: "+sum);
        txtOutput.setText(result.toString());
    }
    
    //Câu d
    private void displayPrimeNumbers() {
        int n = getNhap();
        if(n<0) return;
        StringBuilder result = new StringBuilder("Các số lẻ <= "+n+": ");
        int sum=0;
        for (int i = 2; i<=n; i++) {
            if(isPrime(i)) {
                result.append(i+" ");
                sum+=i;
            }
        }
        result.append("\nTổng: "+sum);
        txtOutput.setText(result.toString());
    }
    
    //Câu e
    private void displayFirstNPrimes() {
        int n = getNhap();
        if(n<0) return;
        StringBuilder result = new StringBuilder("Các số lẻ <= "+n+": ");
        int sum=0, count=0, number=2;
        while(count<n) {
            if(isPrime(number)) {
                result.append(number+" ");
                sum+=number;
                count++;
            }
            number++;
        }
        result.append("\nTổng: "+sum);
        txtOutput.setText(result.toString());
    }

    private boolean isPrime(int n) {
        if(n<2) return false;
        for(int i=2; i<=Math.sqrt(n); i++) {
            if(n%i==0)  return false;
        }
        return true;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai6().setVisible(true));
    }
}
