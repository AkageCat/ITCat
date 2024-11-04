package org.example;

import javax.swing.*;
import java.awt.*;

public class MyLabel extends JLabel {
    public MyLabel(String text) {
        super(text);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // text
        g2d.setComposite(AlphaComposite.getInstance(AlphaComposite.SRC_OVER, 1f));
        g2d.setFont(getFont());

        GradientPaint gradient = new GradientPaint(0, 0, new Color(0xBA88FF), getWidth(), 0, new Color(0x5C82F5));
        g2d.setPaint(gradient);

        FontMetrics fm = g2d.getFontMetrics();
        int x = (getWidth() - fm.stringWidth(getText())) / 2;
        int y = (getHeight() + fm.getAscent()) / 2 - 5; // С учетом смещения по центру
        g2d.drawString(getText(), x, y);

        g2d.dispose();
    }
}
