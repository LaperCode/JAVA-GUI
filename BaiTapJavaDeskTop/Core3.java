import javax.swing.JFrame;
import java.awt.*;

public class Core3 {
    public static void main(String[] args) {
        Toolkit kit = Toolkit.getDefaultToolkit();
        Dimension screenSize = kit.getScreenSize();
        int screenWidth = screenSize.width;
        int screenHeight = screenSize.height;
        JFrame frame = new JFrame("My frame");
        frame.setSize(screenWidth, screenHeight);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
