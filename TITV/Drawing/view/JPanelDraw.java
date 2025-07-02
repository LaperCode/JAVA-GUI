package TITV.Drawing.view;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class JPanelDraw extends JPanel {
    public JPanelDraw() {
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.RED);
        g.drawLine(15, 15, 50, 150);

        g.setColor(Color.BLUE);
        g.drawOval(225, 225, 50, 50);

        g.setColor(Color.GREEN);
        g.drawRect(45, 150, 30, 90);

        g.setColor(Color.PINK);
        g.fillOval(400, 300, 50, 50);

        g.setColor(Color.DARK_GRAY);
        g.fillRect(100, 300, 150, 150);

        g.setColor(Color.YELLOW);
        g.drawString("HELLO LẬP", 250, 250);
    }
    
}
