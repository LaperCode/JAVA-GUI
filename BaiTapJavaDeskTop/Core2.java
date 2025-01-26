import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Core2 {
    public static void main(String[] args) {
        JFrame frame = new JFrame("New Frame");
        frame.setLayout(null);
        frame.setSize(500, 500);
        frame.setLocation(500, 100);

        final JButton button = new JButton("Click here to end program");
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if(e.getSource()==button) {
                    System.exit(0);
                }
            }
        });
        button.setBounds(100, 100, 200, 50);
        frame.add(button);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // frame.pack();
        frame.setVisible(true);
    }
}
