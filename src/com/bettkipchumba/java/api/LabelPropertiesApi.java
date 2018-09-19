
package com.bettkipchumba.java.api;

import java.awt.Color;
import java.awt.Font;
import java.util.List;
import javax.swing.JLabel;

/**
 *
 * @author corneliouz
 */
public class LabelPropertiesApi {
         public static void labelsDeclaration(List<JLabel> label) {
        label.stream()
                .forEach(e -> {
                    e.setFont(new Font("calibri", Font.PLAIN, 14));
                    e.setForeground(Color.decode("#1e90ff"));
                });

    }

}
