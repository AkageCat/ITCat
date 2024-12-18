package org.example;

import javax.swing.*;
import java.awt.*;

public class MyButton extends JButton {
    Color white = new Color(255, 255, 255);
    Color shadow = new Color(174, 181, 255, 35);

    public MyButton(String text) {
        super(text);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setFocusPainted(false);
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();

        // shadow
        g2d.setColor(shadow);
        g2d.fillRoundRect(0, 0, getWidth(), getHeight(), 68, 68);

        // button
        g2d.setColor(white);
        g2d.fillRoundRect(5, 5, getWidth() - 10, getHeight() - 10, 58, 58);

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
