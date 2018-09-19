/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bettkipchumba.java.api;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.List;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author corneliouz
 */
public class TextFieldsPropertiesApi {
        public static void JTextfieldsProperties(List<JTextField> fields) {
       fields.stream()
               .forEach( e -> {
                   e.setBorder( new LineBorder(Color.decode("#c0c0c0"),2,true));
                   e.addFocusListener(
                           new FocusListener() {
                       @Override
                       public void focusGained(FocusEvent ex) {
                           e.setBorder( new LineBorder(Color.decode("#1E90FF"),2,true));
                       }

                       @Override
                       public void focusLost(FocusEvent ex) {
                           e.setBorder( new LineBorder(Color.decode("#c0c0c0"),2,true));
                       }
                   }
                   );
               });
    }

}
