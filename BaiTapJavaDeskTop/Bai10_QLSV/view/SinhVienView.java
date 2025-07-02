package Bai10_QLSV.view;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
// import javax.swing.JList;
// import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Bai10_QLSV.model.SinhVienModel;

public class SinhVienView extends JFrame {
    private SinhVienModel sinhVienModel;
    private JTextField jTextField_ho, jTextField_ten;
    private JSpinner jSpinnerAge, jSpinnerGPA;
    private JRadioButton rdoBtn_Nam, rdoBtn_Nu;
    private JTextArea jTextArea_diachi, txtDisplay;
    private JComboBox<String> cbDepartment;
    private JCheckBox cbWEB, cbOS, cbJAVA, cbAI, cbSQL;
    // private JList<String> clubs;
    private JButton btnTimHo, btnTimTen, btnLocTheoGioiTinh, btnLocTheoMaNganh;
    
    public SinhVienView() {
        this.sinhVienModel = new SinhVienModel();
        this.init();
    }

    public void init() {
        this.setTitle("Quản Lý Sinh Viên");
        this.setSize(600,500);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10,10));

        Font f = new Font("Arial", Font.PLAIN, 10);

        //Panel nhập chứa 8 thuộc tính
        JPanel panelInput = new JPanel(new GridLayout(10,2,5,5));
        JLabel lbl_ho = new JLabel("Nhập họ lót: ");
        jTextField_ho = new JTextField(10);
        JLabel lbl_ten = new JLabel("Nhập tên: ");
        jTextField_ten = new JTextField(10);
        JLabel lbl_ngaySinh = new JLabel("Tuổi: ");
        jSpinnerAge = new JSpinner(new SpinnerNumberModel(18,17,100,1));

        //RadioButton để chọn giới tính
        JPanel panelSex = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel lbl_sex = new JLabel("Chọn giới tính");
        rdoBtn_Nam =new JRadioButton("Nam");
        rdoBtn_Nu =new JRadioButton("Nữ");
        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(rdoBtn_Nam);
        buttonGroup.add(rdoBtn_Nu);
        panelSex.add(lbl_sex);
        panelSex.add(rdoBtn_Nam);
        panelSex.add(rdoBtn_Nu);

        //TextArea để nhập địa chỉ
        JLabel lbl_diachi = new JLabel("Nhập địa chỉ: ");
        jTextArea_diachi = new JTextArea(2, 15);
        
        JLabel lbl_nganh = new JLabel("Chọn ngành: ");
        String[] departments = {"Khoa học dữ liệu", "Kỹ thuật máy tính", "Kỹ thuật máy tính", "Khoa học máy tính", "Data Engineer", "Data Anlalysis"};
        cbDepartment = new JComboBox<>(departments);

        //CheckBox để chọn môn
        JPanel panelSubjects = new JPanel(new GridLayout(2,3,10,10));
        JLabel lbl_MonHoc = new JLabel("Môn học đăng ký: ");
        cbSQL = new JCheckBox("Cơ sở dữ liệu");
        cbAI = new JCheckBox("Cơ sở trí tuệ nhân tạo");
        cbOS = new JCheckBox("Hệ điều hành");
        cbWEB = new JCheckBox("Lập trình web 1");
        cbJAVA = new JCheckBox("Lập trình java");
        panelSubjects.add(cbSQL);
        panelSubjects.add(cbAI);
        panelSubjects.add(cbOS);
        panelSubjects.add(cbWEB);
        panelSubjects.add(cbJAVA);

        
        
        panelInput.add(lbl_ho);
        panelInput.add(jTextField_ho);
        panelInput.add(lbl_ten);
        panelInput.add(jTextField_ten);
        panelInput.add(panelSex);
        panelInput.add(new JLabel());
        panelInput.add(lbl_ngaySinh);
        panelInput.add(jSpinnerAge);
        panelInput.add(lbl_diachi);
        panelInput.add(new JScrollPane(jTextArea_diachi));
        panelInput.add(lbl_nganh);
        panelInput.add(cbDepartment);
        panelInput.add(lbl_MonHoc);
        panelInput.add(panelSubjects);
        panelInput.add(new JLabel("GPA"));
        jSpinnerGPA = new JSpinner(new SpinnerNumberModel(0.0, 0.0, 4.0, 0.1));
        panelInput.add(jSpinnerGPA);
        
        JPanel panelButtons = new JPanel(new FlowLayout());
        panelButtons.setBackground(Color.PINK);
        JButton btnAdd = new JButton("<Thêm>");
        JButton btnEdit = new JButton("<Sửa>");
        JButton btnClear = new JButton("<Xóa>");
        panelButtons.add(btnEdit);
        panelButtons.add(btnAdd);
        panelButtons.add(btnClear);
        this.add(panelButtons, BorderLayout.SOUTH);

        //Panel show kết quả 
        JPanel panelResult = new JPanel(new BorderLayout());
        panelResult.setPreferredSize(new Dimension(500, 800));
        panelResult.setBackground(Color.BLUE);

        JLabel lblInfo = new JLabel("Thông tin sinh viên", SwingConstants.CENTER);
        lblInfo.setFont(new Font("Arial", Font.BOLD, 18));

        txtDisplay = new JTextArea();
        txtDisplay.setFont(new Font("Arial", Font.PLAIN, 14));
        txtDisplay.setEditable(false);
        txtDisplay.setBorder(BorderFactory.createLineBorder(Color.BLACK));

        panelResult.add(lblInfo, BorderLayout.NORTH);
        panelResult.add(new JScrollPane(txtDisplay), BorderLayout.CENTER);
        
        
        this.add(panelInput, BorderLayout.WEST);
        this.add(panelResult, BorderLayout.CENTER);

        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateDisplay();
            }
        });

        // Sự kiện nút "Clear"
        btnClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearFields();
            }
        });

        this.setVisible(true);
    }

    private StringBuilder studentList = new StringBuilder();

    private void updateDisplay() {
        String ho = jTextField_ho.getText().trim();
        String name = jTextField_ten.getText().trim();
        int age = (int) jSpinnerAge.getValue();
        String gender = rdoBtn_Nam.isSelected() ? "Male" : rdoBtn_Nu.isSelected() ? "Female" : "Other";
        String address = jTextArea_diachi.getText().trim();
        String department = (String) cbDepartment.getSelectedItem();
        double gpa = (double) jSpinnerGPA.getValue();


        String subjects = "";
        if (cbSQL.isSelected()) subjects += "Cơ sở dữ liệu, ";
        if (cbAI.isSelected()) subjects += "Cơ sở trí tuệ nhân tạo, ";
        if (cbOS.isSelected()) subjects += "Hệ điều hành, ";
        if (cbWEB.isSelected()) subjects += "Lập trình web 1, ";
        if (cbJAVA.isSelected()) subjects += "Lập trình Java, ";
        if (!subjects.isEmpty()) subjects = subjects.substring(0, subjects.length() - 2);

        // Thêm sinh viên mới vào danh sách
        studentList.append(
            "ID: " + ho + "\n" +
            "Tên: " + name + "\n" +

            "Tuổi: " + age + "\n" +
            "Giới tính: " + gender + "\n" +

            "Địa chỉ: " + address + "\n" +
            "Khoa: " + department + "\n" +
            "Môn học đã đăng kí: " + subjects + "\n" +
            "GPA: " + gpa + "\n" +
            "--------------------------\n"
        );

        // Cập nhật nội dung hiển thị
        txtDisplay.setText(studentList.toString());
    }

    // Hàm xóa dữ liệu nhập vào
    private void clearFields() {
        jTextField_ho.setText("");
        jTextField_ten.setText("");
        jSpinnerAge.setValue(18);
        rdoBtn_Nam.setSelected(true);
        jTextArea_diachi.setText("");
        cbDepartment.setSelectedIndex(0);
        cbSQL.setSelected(false);
        cbAI.setSelected(false);
        cbOS.setSelected(false);
        cbWEB.setSelected(false);
        cbJAVA.setSelected(false);
        jSpinnerGPA.setValue(0.0);
        txtDisplay.setText("");
    }
}

