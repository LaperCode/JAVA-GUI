package TITV;

import javax.swing.JFrame;

public class MyClass extends JFrame {
    public MyClass() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Khi tắt một cửa sổ JFrame thì sẽ tắt các JFrame còn lại
    }

    public void showIt() {
        this.setVisible(true);

    }

    public void showIt(String title) {
        this.setTitle(title);
        this.setVisible(true);
    }

    public void showIt(String title, int width, int height) {
        this.setTitle(title);
        this.setSize(width, height);
        this.setVisible(true);
    }

    public static void main(String[] args) {
        MyClass m1 = new MyClass();
        m1.showIt();

        MyClass m2 = new MyClass();
        m2.showIt("Window 2");
        
        MyClass m3 = new MyClass();
        m3.showIt("Window 3", 600, 400);
    }
}
