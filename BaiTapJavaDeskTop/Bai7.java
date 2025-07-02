// import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bai7 extends JFrame {
    private JTextField txtNum1, txtNum2, txtAnswer;
    private JRadioButton rdoPlus, rdoSub, rdoMul, rdoDiv;
    private JButton btnCheck, btnDelete, btnClose;
    private JLabel lblThongBao;

    public Bai7() {
        this.setTitle("CÙNG NHAU GIÚP BÉ LÀM TOÁN NÀO!!!");
        this.setSize(600, 400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        this.getContentPane().setBackground(new Color(230, 240, 255));
        
        //Label tiêu đề nhập và nhập xuất dữ liệu và panel p0
        JLabel lblNum1 = new JLabel("Bé nhập số tự nhiên thứ 1: ", JLabel.RIGHT);
        txtNum1 = new JTextField(10);
        JLabel lblNum2 = new JLabel("Bé nhập số tự nhiên thứ 2: ", JLabel.RIGHT);
        txtNum2 = new JTextField(10);
        Panel p0 = new Panel(new FlowLayout(FlowLayout.LEFT));
        p0.add(lblNum1);
        p0.add(txtNum1);
        p0.add(lblNum2);
        p0.add(txtNum2);
        
        //Label chọn phép toán và panel p1
        JLabel lblPhepToan = new JLabel("Chọn phép toán: ", JLabel.RIGHT);
        //Các radioButton phép tính
        rdoPlus = new JRadioButton("+");
        rdoSub = new JRadioButton("-");
        rdoMul = new JRadioButton("*");
        rdoDiv = new JRadioButton("/");
        rdoPlus.setPreferredSize(new Dimension(60, 40));
        rdoSub.setPreferredSize(new Dimension(60, 40));
        rdoMul.setPreferredSize(new Dimension(60, 40));
        rdoDiv.setPreferredSize(new Dimension(60, 40));
        // //nhóm các btn phép tính lại với nhau
        ButtonGroup btnPhepToan = new ButtonGroup();
        btnPhepToan.add(rdoPlus);
        btnPhepToan.add(rdoSub);
        btnPhepToan.add(rdoMul);
        btnPhepToan.add(rdoDiv);
        //Panel phép toán
        JPanel p1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        p1.add(lblPhepToan);
        p1.add(rdoPlus);
        p1.add(rdoSub);
        p1.add(rdoMul);
        p1.add(rdoDiv);

        //Label đáp án và panel p2
        JLabel lblAnswer = new JLabel("Mời bé nhập đáp số: ", JLabel.RIGHT);
        txtAnswer = new JTextField(20);
        btnCheck = new JButton("Kiểm tra");
        btnDelete = new JButton("Xóa");
        btnClose = new JButton("Đóng");
        lblThongBao = new JLabel("");
        Panel p2 = new Panel(new FlowLayout(FlowLayout.LEFT));
        p2.add(lblAnswer);
        p2.add(txtAnswer);
        p2.add(btnCheck);
        p2.add(btnDelete);
        p2.add(btnClose);

        JPanel p3 = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel reseult_Label = new JLabel("Kết quả để so sánh: ");
        p3.add(reseult_Label);
        p3.add(lblThongBao);
        
        //Thêm Listener cho btnCheck
        btnCheck.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkResult();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtNum1.setText("");
                txtNum2.setText("");
                txtAnswer.setText("");
            }
        });
        btnClose.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        this.add(p0);
        this.add(p1);
        this.add(p2);
        this.add(p3);
        
        this.setVisible(true);
    }

    //Hàm ktra kết quả
    private void checkResult() {
        try {
            int num1 = Integer.parseInt(txtNum1.getText().trim());
            int num2 = Integer.parseInt(txtNum2.getText().trim());
            int userAnswer = Integer.parseInt(txtAnswer.getText().trim());

            int correctResult = 0;        //kết quả cần đúng
            char selectedOperator = ' ';  //ký tự phép tính để chọn

            if(rdoPlus.isSelected()) {
                correctResult = num1+num2;
                selectedOperator = '+';
            } else if(rdoSub.isSelected()) {
                correctResult = num1-num2;
                selectedOperator = '-';
            } else if(rdoMul.isSelected()) {
                correctResult = num1*num2;
                selectedOperator = '*';
            } else if(rdoDiv.isSelected()) {
                if(num2==0) {
                    JOptionPane.showMessageDialog(this, "Không thể chia cho 0!");
                    return;
                }
                correctResult = num1/num2;
                selectedOperator = '/';
            } else {
                JOptionPane.showMessageDialog(this, "Vui lòng chọn phép toán!");
                return;
            }

            //Nếu đáp án của bé đúng với đáp án cần đúng thì bé THÔNG MINH
            if(userAnswer == correctResult) {
                lblThongBao.setText("Bé đã tính đúng!");
            } else {
                lblThongBao.setText("Sai! Đáp án chính xác là: "+num1+" "+selectedOperator+" "+num2+" = "+correctResult);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Bai7());
        // new Bai7();
    }
}