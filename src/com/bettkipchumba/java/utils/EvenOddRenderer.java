
package com.bettkipchumba.java.utils;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author corneliouz
 */
public class EvenOddRenderer implements TableCellRenderer {

    public final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();

    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component renderer = DEFAULT_RENDERER.getTableCellRendererComponent(
                table, value, isSelected, hasFocus, row, column);
        ((JLabel) renderer).setOpaque(true);
        Color foreground, background;
        if (isSelected) {
            foreground = Color.WHITE;
            background = Color.decode("#1a8cff");
        } else if (row % 2 == 0) {
            foreground = Color.BLACK;
            background = Color.white;
        } else {
            foreground = Color.BLACK;
            background = Color.decode("#e0e0d1");
        }
        renderer.setForeground(foreground);
        renderer.setBackground(background);
        return renderer;
    }
}
