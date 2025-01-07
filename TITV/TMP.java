package TITV;

import javax.swing.JFrame;

public class TMP {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setTitle("Ví dụ JFrame");  // Gán tên tiêu đề cho JFrame 
        jf.setSize(600, 400);  // Chỉnh kích thước chiều rộng, chiều dài JFrame
        
        // while (true) {
            //     System.out.println("Chương trình đang chạy...");
            // }
            
            // Thoát ra khỏi chương trình khi đóng cửa sổ JFrame
            jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            
            // Cho phép hiển thị JFrame
            jf.setVisible(true);

            // Gán vị trí hiển thị
            jf.setLocation(300, 300);
        }
}