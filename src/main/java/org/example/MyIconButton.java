package org.example;

import javax.swing.*;

public class MyIconButton extends JButton {
    public MyIconButton(Icon icon) {
        super(icon);
        setContentAreaFilled(false); // Убираем фон
        setBorderPainted(false); // Убираем границу
        setFocusPainted(false); // Убираем эффект фокуса
        setRolloverEnabled(false); // Отключаем эффект при наведении
        setOpaque(false); // Делаем кнопку прозрачной
    }
}
