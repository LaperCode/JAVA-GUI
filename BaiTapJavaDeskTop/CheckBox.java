import javax.swing.JFrame;
import java.awt.*;
import java.awt.event.*;;

public class CheckBox {
    public static void main(String[] args) {
        JFrame frame = new JFrame("CheckBoxExample");
        Checkbox checkBox = new Checkbox("Documents", false);
        checkBox.addItemListener(new ItemListener() {
            public void itemStateChanged(ItemEvent e) {
                // System.out.println("Changed");
                if(e.getStateChange()==ItemEvent.SELECTED)  // màn hình in ra chỉ khi nào nó được chọn mà thôi
                    System.out.println("Changed");
            }
        });
        frame.add(checkBox);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
