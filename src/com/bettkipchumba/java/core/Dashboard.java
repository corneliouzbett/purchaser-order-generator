package com.bettkipchumba.java.core;

import javax.swing.*;
import java.awt.*;

/**
 *
 * @author CorneliouzBett
 */
public class Dashboard extends JPanel {

    public Dashboard() {
        setSize(1050, 680);
        setLayout(null);
        setBackground(Color.WHITE);

        JLabel backgroundLabel = new JLabel("");
        backgroundLabel.setBounds(0,0,1100,700);
        backgroundLabel.setIcon(new ImageIcon(getClass().getResource("images/bac.png")));

        add(backgroundLabel);

        repaint();
        setVisible(true);
    }
}
