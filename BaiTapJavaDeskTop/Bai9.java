import java.awt.BorderLayout;
import java.awt.Color;
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

public class Bai9 extends JFrame {
    private JTextField txtString;
    private JButton btnLengthString, btnRemoveSpace, btnCountChar, btnKChar, btnNCharAtK;
    private JTextArea txtOutput;

    public Bai9() {
        this.init();
        this.setVisible(true);
    }

    public void init() {
        this.setTitle("Làm việc với chuỗi");
        this.setSize(500, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout());

        //Panel nhập chuỗi
        JPanel panelInput = new JPanel(new FlowLayout());
        JLabel lbl_str = new JLabel("Nhập chuỗi s: ");
        panelInput.setBackground(Color.LIGHT_GRAY);
        txtString = new JTextField(20);
        panelInput.add(lbl_str);
        panelInput.add(txtString);

        //Panel các nút
        JPanel panelButtons = new JPanel(new GridLayout(5,1,5,5));
        btnLengthString = new JButton("<Độ dài chuỗi s>");
        btnLengthString.setBackground(Color.GREEN);
        btnRemoveSpace = new JButton("<Xóa bỏ khoảng trắng thừa>");
        btnRemoveSpace.setBackground(Color.GREEN);
        btnCountChar = new JButton("<Đếm số từ và xuất mỗi từ>");
        btnCountChar.setBackground(Color.GREEN);
        btnKChar = new JButton("<k kí tự bên trái và k kí tự bên phải>");
        btnKChar.setBackground(Color.GREEN);
        btnNCharAtK = new JButton("<Xuất n kí tự của s kể từ vị trí k>");
        btnNCharAtK.setBackground(Color.GREEN);
        panelButtons.add(btnLengthString);
        panelButtons.add(btnRemoveSpace);
        panelButtons.add(btnCountChar);
        panelButtons.add(btnKChar);
        panelButtons.add(btnNCharAtK);

        txtOutput = new JTextArea("Kết quả:", 10,10);
        txtOutput.setBackground(Color.WHITE);
        txtOutput.setEditable(false);
        txtOutput.setLineWrap(true);
        txtOutput.setWrapStyleWord(true);
        JScrollPane scrollPane = new JScrollPane(txtOutput);

        btnLengthString.addActionListener(_ -> lengthWord());
        btnRemoveSpace.addActionListener(_ -> removeSpace());
        btnCountChar.addActionListener(_ -> countChar());
        btnKChar.addActionListener(_ -> kCharLeftRight());
        btnNCharAtK.addActionListener(_ -> nCharAtIndexK());
        
        this.add(panelInput, BorderLayout.NORTH);
        this.add(panelButtons, BorderLayout.WEST);
        this.add(scrollPane, BorderLayout.CENTER);
    }

    private void lengthWord() {
        String str = txtString.getText().trim();
        int length = str.length();
        txtOutput.setText("Độ dài của chuỗi \""+str+"\": "+length);
    }

    private void removeSpace() {
        String str = txtString.getText().trim(); //Xóa khoảng trắng đầu và cuối
        str = str.replaceAll("\\s+", " "); //Thay nhiều khoảng trắng thành một
        txtOutput.setText("Chuỗi sau khi xóa khoảng trắng dư thừa:\n \"" + str + "\"");
    }

    private void countChar() {
        String str = txtString.getText().trim();
        StringBuilder sb =new StringBuilder();
        int count=0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) != ' ') {
                sb.append(str.charAt(i)+" ");
                count++;
            }
        }
        txtOutput.setText(sb.toString()+"\nSố ký tự của chuỗi \""+str+"\": "+count);
    }

    private void kCharLeftRight() {
        String str = txtString.getText().trim();
        if (str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chuỗi không được để trống!");
            return;
        }
        try {
            int k = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số tự nhiên k"));
            if (k < 0 || k >= str.length()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương và không quá độ dài chuỗi!");
                return;
            }
            String left = str.substring(0, k);
            String right = str.substring(str.length()-k);
            txtOutput.setText(k+" ký tự bên trái: " + left + "\n" +
                            +k+ " ký tự bên phải: " + right);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    private void nCharAtIndexK() {
        String str = txtString.getText().trim();
        if (str.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Chuỗi không được để trống!");
            return;
        }
        try {
            int k = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số tự nhiên k:"));
            int n = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập số tự nhiên n:"));
            if(k<0 || k>=str.length()) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương không quá độ dài chuỗi!");
                return;
            }
            if(n<0) {
                JOptionPane.showMessageDialog(this, "Vui lòng nhập số nguyên dương!");
                return;
            }
            String tmp = str.substring(k, Math.min(n+k, str.length()));
            txtOutput.setText(n+" ký tự của chuỗi \""+str+"\" từ vị trí "+k+": "+tmp);

        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        new Bai9();
    }
}
