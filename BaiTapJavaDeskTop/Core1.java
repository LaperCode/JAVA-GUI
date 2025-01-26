import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.awt.*;
import java.awt.event.*;

class Core1 extends JFrame {
    Container container = getContentPane();

    public Core1(String title) {
        super(title);
        Button button = new Button("My button");
        EventQuit eventQuit = new EventQuit();
        button.addActionListener(eventQuit);
        container.add(button);
    }

    public static void main(String a[]) {
        Core1 exe = new Core1("Frame&quot");
        exe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        exe.pack();
        exe.setVisible(true);
    }

    class EventQuit implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            // System.exit(0);
            JOptionPane.showMessageDialog(rootPane, "hi", "Lập", EXIT_ON_CLOSE);
        }
    }
}