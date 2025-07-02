// package vdframe_nhan;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Vector;
import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.table.DefaultTableModel;
import com.toedter.calendar.JDateChooser;

class SinhVien {
    String ma, ho, ten, ngaySinh, gt, khoa, diaChi, sdt;

    public SinhVien(String ma, String ho, String ten, String ngaySinh, String gt, String khoa, String diaChi, String sdt) {
        this.ma = ma;
        this.ho = ho;
        this.ten = ten;
        this.ngaySinh = ngaySinh;
        this.gt = gt;
        this.khoa = khoa;
        this.diaChi = diaChi;
        this.sdt = sdt;
    }

    public Object[] toObjectArray() {
        return new Object[]{ma, ho, ten, ngaySinh, gt, khoa, diaChi, sdt};
    }
}

public class TableTest extends JFrame {
    private JTable table;
    private DefaultTableModel model;
    private JTextField txt_ma, txt_ho, txt_ten, txt_dc, txt_sdt, txt_timkiem;
    private JButton btnAdd, btnEdit, btnDelete, btnQuit, btnSearch, btnRefresh;
    private JDateChooser txt_ngaysinh;
    private JComboBox<String> cbKhoa;
    private JRadioButton rbNam, rbNu, rbMa, rbHo, rbTen;
    private ButtonGroup groupGT, groupTK;
    private JLabel lblKetQua;
    private ArrayList<SinhVien> danhSachSV;

    public TableTest() {
        setTitle("Quản lý Sinh Viên");
        setSize(900, 700);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        danhSachSV = new ArrayList<>();

        // ===== KHỞI TẠO TABLE =====
        Vector<String> header = new Vector<>();
        header.add("Mã SV");
        header.add("Họ SV");
        header.add("Tên SV");
        header.add("Ngày sinh");
        header.add("Giới tính");
        header.add("Khoa");
        header.add("Địa chỉ");
        header.add("SĐT");

        model = new DefaultTableModel(new Vector<>(), header);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);

        // nhập liệu
        JPanel inputPanel = new JPanel(new GridLayout(5, 4, 5, 5));
        txt_ma = new JTextField(10);
        txt_ho = new JTextField(10);
        txt_ten = new JTextField(10);
        txt_ngaysinh = new JDateChooser();
        txt_ngaysinh.setDateFormatString("dd/MM/yyyy");

        rbNam = new JRadioButton("Nam");
        rbNu = new JRadioButton("Nữ");
        groupGT = new ButtonGroup();
        groupGT.add(rbNam);
        groupGT.add(rbNu);

        String[] dsKhoa = {"CNTT", "KTPM", "HTTT", "KHMT"};
        cbKhoa = new JComboBox<>(dsKhoa);

        txt_dc = new JTextField(10);
        txt_sdt = new JTextField(10);

        inputPanel.add(new JLabel("Mã SV:"));
        inputPanel.add(txt_ma);
        inputPanel.add(new JLabel("Họ SV:"));
        inputPanel.add(txt_ho);
        inputPanel.add(new JLabel("Tên SV:"));
        inputPanel.add(txt_ten);
        inputPanel.add(new JLabel("Ngày sinh:"));
        inputPanel.add(txt_ngaysinh);

        inputPanel.add(new JLabel("Giới tính:"));
        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        genderPanel.add(rbNam);
        genderPanel.add(rbNu);
        inputPanel.add(genderPanel);

        inputPanel.add(new JLabel("Khoa:"));
        inputPanel.add(cbKhoa);
        inputPanel.add(new JLabel("Địa chỉ:"));
        inputPanel.add(txt_dc);
        inputPanel.add(new JLabel("SĐT:"));
        inputPanel.add(txt_sdt);

        // ===== BUTTON PANEL =====
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        btnAdd = new JButton("Thêm");
        btnEdit = new JButton("Sửa");
        btnDelete = new JButton("Xóa");
        btnQuit = new JButton("Thoát");

        buttonPanel.add(btnAdd);
        buttonPanel.add(btnEdit);
        buttonPanel.add(btnDelete);
        buttonPanel.add(btnQuit);

        // ===== SEARCH PANEL =====
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 10));
        searchPanel.add(new JLabel("Nhập từ khóa:"));
        txt_timkiem = new JTextField(10);
        searchPanel.add(txt_timkiem);

        rbMa = new JRadioButton("Mã");
        rbHo = new JRadioButton("Họ");
        rbTen = new JRadioButton("Tên");
        groupTK = new ButtonGroup();
        groupTK.add(rbMa);
        groupTK.add(rbHo);
        groupTK.add(rbTen);
        // Mặc định chọn tìm kiếm theo Mã
        rbMa.setSelected(true);

        searchPanel.add(rbMa);
        searchPanel.add(rbHo);
        searchPanel.add(rbTen);

        btnSearch = new JButton("Tìm kiếm");
        searchPanel.add(btnSearch);

        lblKetQua = new JLabel("Kết quả:");
        searchPanel.add(lblKetQua);
        
        
        btnRefresh = new JButton("Refresh");
        searchPanel.add(btnRefresh);

       //layout chính
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.Y_AXIS));
        topPanel.add(inputPanel);
        topPanel.add(buttonPanel);
        
        Container container = getContentPane();
        container.setLayout(new BorderLayout(10, 10));
        container.add(topPanel, BorderLayout.NORTH);
        container.add(scrollPane, BorderLayout.CENTER);
        container.add(searchPanel, BorderLayout.SOUTH);

        // ===== SỰ KIỆN NÚT =====
        btnAdd.addActionListener(e -> addRow());
        btnEdit.addActionListener(e -> editRow());
        btnDelete.addActionListener(e -> deleteRow());
        btnQuit.addActionListener(e -> System.exit(0));
        btnSearch.addActionListener(e -> search());
        btnRefresh.addActionListener(e -> refreshTable());

        table.getSelectionModel().addListSelectionListener((ListSelectionEvent e) -> {
            if (!e.getValueIsAdjusting()) {
                fillInputFields();
            }
        });

        setVisible(true);
    }

    // Thêm một dòng mới vào bảng và danh sách
    private void addRow() {
        String ma = txt_ma.getText();
        String ho = txt_ho.getText();
        String ten = txt_ten.getText();
        String ngaySinh = ((JTextField) txt_ngaysinh.getDateEditor().getUiComponent()).getText();
        String gt = rbNam.isSelected() ? "Nam" : "Nữ";
        String khoa = cbKhoa.getSelectedItem().toString();
        String dc = txt_dc.getText();
        String sdt = txt_sdt.getText();

        SinhVien sv = new SinhVien(ma, ho, ten, ngaySinh, gt, khoa, dc, sdt);
        danhSachSV.add(sv);
        model.addRow(sv.toObjectArray());
        clearFields();
    }

    // Sửa dòng được chọn
    private void editRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Vui lòng chọn dòng cần sửa!", "Lỗi", JOptionPane.WARNING_MESSAGE);
            return;
        }

        model.setValueAt(txt_ma.getText(), selectedRow, 0);
        model.setValueAt(txt_ho.getText(), selectedRow, 1);
        model.setValueAt(txt_ten.getText(), selectedRow, 2);
        model.setValueAt(((JTextField) txt_ngaysinh.getDateEditor().getUiComponent()).getText(), selectedRow, 3);
        model.setValueAt(rbNam.isSelected() ? "Nam" : "Nữ", selectedRow, 4);
        model.setValueAt(cbKhoa.getSelectedItem().toString(), selectedRow, 5);
        model.setValueAt(txt_dc.getText(), selectedRow, 6);
        model.setValueAt(txt_sdt.getText(), selectedRow, 7);

        // Cập nhật lại đối tượng trong danh sách
        SinhVien sv = danhSachSV.get(selectedRow);
        sv.ma = txt_ma.getText();
        sv.ho = txt_ho.getText();
        sv.ten = txt_ten.getText();
        sv.ngaySinh = ((JTextField) txt_ngaysinh.getDateEditor().getUiComponent()).getText();
        sv.gt = rbNam.isSelected() ? "Nam" : "Nữ";
        sv.khoa = cbKhoa.getSelectedItem().toString();
        sv.diaChi = txt_dc.getText();
        sv.sdt = txt_sdt.getText();

        clearFields();
    }

    // Xóa dòng được chọn
    private void deleteRow() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            danhSachSV.remove(selectedRow);
            model.removeRow(selectedRow);
        }
    }

    // Tìm kiếm và hiển thị kết quả tìm kiếm (làm mới bảng với các dòng phù hợp)
    private void search() {
        String keyword = txt_timkiem.getText().trim().toLowerCase();
        if (keyword.isEmpty()) {
            lblKetQua.setText("Vui lòng nhập từ khóa tìm kiếm");
            return;
        }
        // Xóa toàn bộ dữ liệu hiện tại trong bảng
        model.setRowCount(0);
        int count = 0;
        for (SinhVien sv : danhSachSV) {
            if ((rbMa.isSelected() && sv.ma.toLowerCase().contains(keyword)) ||
                (rbHo.isSelected() && sv.ho.toLowerCase().contains(keyword)) ||
                (rbTen.isSelected() && sv.ten.toLowerCase().contains(keyword))) {
                model.addRow(sv.toObjectArray());
                count++;
            }
        }
        lblKetQua.setText("Tìm thấy: " + count + " sinh viên");
    }
    
    // Phục hồi bảng về trạng thái ban đầu (tất cả các dữ liệu đã thêm)
    private void refreshTable() {
        model.setRowCount(0);
        for (SinhVien sv : danhSachSV) {
            model.addRow(sv.toObjectArray());
        }
        lblKetQua.setText("Kết quả:");
        txt_timkiem.setText("");
    }

    // Điền thông tin từ dòng được chọn vào các ô nhập liệu
    private void fillInputFields() {
        int selectedRow = table.getSelectedRow();
        if (selectedRow != -1) {
            txt_ma.setText(model.getValueAt(selectedRow, 0).toString());
            txt_ho.setText(model.getValueAt(selectedRow, 1).toString());
            txt_ten.setText(model.getValueAt(selectedRow, 2).toString());
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                txt_ngaysinh.setDate(sdf.parse(model.getValueAt(selectedRow, 3).toString()));
            } catch (Exception e) {
                txt_ngaysinh.setDate(null);
            }
            String gt = model.getValueAt(selectedRow, 4).toString();
            rbNam.setSelected(gt.equals("Nam"));
            rbNu.setSelected(gt.equals("Nữ"));
            cbKhoa.setSelectedItem(model.getValueAt(selectedRow, 5).toString());
            txt_dc.setText(model.getValueAt(selectedRow, 6).toString());
            txt_sdt.setText(model.getValueAt(selectedRow, 7).toString());
        }
    }

    // Xóa các ô nhập liệu
    private void clearFields() {
        txt_ma.setText("");
        txt_ho.setText("");
        txt_ten.setText("");
        txt_ngaysinh.setDate(null);
        groupGT.clearSelection();
        cbKhoa.setSelectedIndex(0);
        txt_dc.setText("");
        txt_sdt.setText("");
    }

    public static void main(String[] args) {
        new TableTest();
    }
}
