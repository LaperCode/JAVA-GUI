import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Bai8 extends JFrame {
    private int[] arr;
    private int N=0;
    private JTextField txtN, txtNewElement, txtRemovedIndex, txtSearchedX;
    private JButton btnEnterArray, btnShowArray, btnEvenNumbers, btnOddNumbers, btnPrimeNumbers, btnAddElement, btnRemoveElement, btnSearchedX;
    private JTextArea txtResult;
    private int width=900, height=500;

    public Bai8() {
        this.setTitle("Mảng với N phần tử số nguyên");
        this.setSize(new Dimension(width, height));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new BorderLayout(10,10));

        Font font = new Font("Arial", Font.BOLD, 20);

        //Panel nhập dữ liệu
        JPanel panelInput = new JPanel(new GridLayout(2,2, 15, 15));
        panelInput.setBackground(Color.ORANGE);
        JLabel lblN_N = new JLabel("- Nhập số phần tử N: ");
        txtN = new JTextField(10);
        btnEnterArray = new JButton("<Nhập mảng>");
        panelInput.add(lblN_N);
        panelInput.add(txtN);
        panelInput.add(btnEnterArray);

        txtNewElement = new JTextField();
        txtNewElement.setFont(font);
        panelInput.add(new JLabel("- Thêm phần tử:"));
        panelInput.add(txtNewElement);
        btnAddElement = new JButton("<Thêm>");
        panelInput.add(btnAddElement);

        txtRemovedIndex = new JTextField();
        txtRemovedIndex.setFont(font);
        panelInput.add(new JLabel("- Xóa phần tử thứ k:"));
        panelInput.add(txtRemovedIndex);
        btnRemoveElement = new JButton("<Xóa>");
        panelInput.add(btnRemoveElement);

        txtSearchedX = new JTextField();
        txtSearchedX.setFont(font);
        panelInput.add(new JLabel("- Tìm số x trong mảng:"));
        panelInput.add(txtSearchedX);
        btnSearchedX = new JButton("<Tìm>");
        panelInput.add(btnSearchedX);

        //Panel các nút theo yêu cầu
        JPanel panelButtons = new JPanel(new FlowLayout(FlowLayout.CENTER, 20,50));
        panelButtons.setBackground(Color.GRAY);
        btnShowArray = new JButton("<Xuất mảng và tính tổng>");
        btnEvenNumbers = new JButton("<Xuất số chẵn và tính tổng>");
        btnOddNumbers = new JButton("<Xuất số lẻ và tính tổng>");
        btnPrimeNumbers = new JButton("<Xuất số nguyên tố và tính tổng>");
        panelButtons.add(btnShowArray);
        panelButtons.add(btnEvenNumbers);
        panelButtons.add(btnOddNumbers);
        panelButtons.add(btnPrimeNumbers);

        // Dùng JScrollPane khỏi cần JPanel
        // JLabel lblResult = new JLabel("Kết quả: ");

        txtResult = new JTextArea(10, 50);
        txtResult.setEditable(false);
        txtResult.setBorder(BorderFactory.createTitledBorder("Kết quả:"));
        txtResult.setFont(new Font("Arial", Font.PLAIN, 16));
        JScrollPane scrollPane = new JScrollPane(txtResult);
        scrollPane.setPreferredSize(new Dimension(850, 200)); // Đặt kích thước lớn hơn
        scrollPane.setBackground(Color.BLUE);

        btnEnterArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                NhapMang();
            }
        });
        btnAddElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addElement();
            }
        });
        btnRemoveElement.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeElement();
            }
        });
        btnSearchedX.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SearchX();
            }
        });
        btnShowArray.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtResult.setText(XuatMang()); // Cập nhật lại kết quả mảng đúng cách
            }
        });
        btnEvenNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showEvenNumbers();
            }
        });
        btnOddNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showOddNumbers();
            }
        });
        btnPrimeNumbers.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showPrimeNumbers();
            }
        });

        this.add(panelInput, BorderLayout.NORTH);
        this.add(panelButtons, BorderLayout.CENTER);
        this.add(scrollPane, BorderLayout.SOUTH);
        this.setBackground(Color.GREEN);

        this.setVisible(true);
    }

    //Nhập mảng
    private void NhapMang() {
        try {
            int size = Integer.parseInt(txtN.getText().trim());
            if(size<=0) {
                JOptionPane.showMessageDialog(this, "N phải lớn hơn 0!");
                return;
            }
            arr = new int[size];
            for(int i=0; i<size; i++) {
                arr[i] = Integer.parseInt(JOptionPane.showInputDialog(this, "Nhập phần tử thứ "+(i+1)+": "));
            }
            N = size; // Cập nhật N sau khi nhập mảng
            txtResult.setText("Mảng đã nhập: "+XuatMang());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    //Hiển thị mảng và tổng
    private String XuatMang() {
        StringBuilder sb = new StringBuilder();
        int sum=0;
        for(int num: arr) {
            sb.append(num+" ");
            sum+=num;
        }
        sb.append("\nTổng: "+sum+"\n");
        return sb.toString();
    }

    //Xuất số chẵn và tổng
    private void showEvenNumbers() {
        StringBuilder sb = new StringBuilder();
        int sum=0;
        for(int num: arr) {
            if(num%2==0) {
                sb.append(num+" ");
                sum+=num;
            }
        }
        sb.append("\nTổng: "+sum);
        txtResult.setText(sb.toString());
    }
    
    //Xuất số lẻ và tổng
    private void showOddNumbers() {
        StringBuilder sb = new StringBuilder();
        int sum=0;
        for(int num: arr) {
            if(num%2==1) {
                sb.append(num+" ");
                sum+=num;
            }
        }
        sb.append("\nTổng: "+sum);
        txtResult.setText(sb.toString());
    }

    //Kiểm tra số nguyên tố
    private boolean isPrime(int n) {
        if(n<2) return false;
        if(n==2)    return true;
        if (n % 2 == 0)    return false; // Loại bỏ số chẵn ngay lập tức    
        for(int i=3; i<=Math.sqrt(n); i+=2) {
            if(n%i==0)    return false;
        }
        return true;
    }

    //Xuất số nguyên tố và tổng
    private void showPrimeNumbers() {
        StringBuilder sb =new StringBuilder();
        int sum=0;
        for (int i = 0; i < arr.length; i++) {
            if(isPrime(arr[i])) {
                sb.append(arr[i]+" ");
                sum+=arr[i];
            }
        }
        sb.append("\nTổng: "+sum);
        txtResult.setText(sb.toString());
    }

    //Thêm phần tử vào mảng
    private void addElement() {
        try {
            int num = Integer.parseInt(txtNewElement.getText().trim());
            int[] newArr;
            newArr = Arrays.copyOf(arr, N+1);
            newArr[N] = num;
            arr = newArr;
            N++;
            txtResult.setText("Mảng sau khi thêm: "+XuatMang());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    //Xóa phần tử thứ k
    private void removeElement() {
        try {
            int index = Integer.parseInt(txtRemovedIndex.getText().trim());
            if(index<0 || index >= N) {
                JOptionPane.showMessageDialog(this, "Vị trí không hợp lệ");
                return;
            }
            int[] newArray = new int[N-1];
            for (int i=0, j=0; i<N; i++) {
                if (i != index)
                    newArray[j++] = arr[i];
            }
            arr = newArray;
            N--;
            txtResult.setText("Mảng sau khi xóa: "+XuatMang());
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    //Tìm phần tử x
    private void SearchX() {
        try {
            int x = Integer.parseInt(txtSearchedX.getText().trim());
            boolean found = false;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i<N; i++) {
                if(arr[i]==x) {
                    sb.append("Phần tử ").append(x).append(" nằm ở vị trí: ").append(i).append("\n");
                    found=true;
                }
            }
            if (!found) {
                sb.append("Phần tử ").append(x).append(" không có trong mảng!\n");
            }
            txtResult.setText(sb.toString());
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Vui lòng nhập số hợp lệ!");
        }
    }

    public static void main(String[] args) {
        new Bai8();
    }
}
