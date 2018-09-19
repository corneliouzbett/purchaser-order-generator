package com.bettkipchumba.java.core;

import com.bettkipchumba.java.api.LabelPropertiesApi;
import com.bettkipchumba.java.api.TextFieldsPropertiesApi;
import com.bettkipchumba.java.db.MysqlConnection;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

    /**
     *
     * @author Corneliouz Bett
     */
    public class AddPurchaseOrderDialog extends JDialog {

        private static JLabel regNoLabel, FName, lastNameLabel, dob, contactLabel, Email, residenceLabel;
        private static JLabel programmeLabel, menubarLabel;
        private static JButton saveButton, closeButton, myimage, userpic;
        private static JTextField regNoField, FnameField, lastNameField;
        private static JTextField contactField, Emailfield;
        private static JPanel userView;
        private static JPanel userViewPanel;
        private static JPanel pic;
        private static JLabel confirmpasswordLabel;
        private static JComboBox residenceField,programmeField;
        private static JPasswordField confirmPasswordfield;
        private static JPasswordField passwordfield;
        private static JLabel password;
        private static JDateChooser datechooser;
        String [] data ={"Non-resident","Resident"};
        static String programme;

        public AddPurchaseOrderDialog() {
            setLayout(null);
            setSize(850, 600);
            setLocation(330,100);
            setBackground(Color.WHITE);

            userViewPanel = new JPanel();
            userViewPanel.setBackground(Color.WHITE);
            userViewPanel.setBounds(0, 40, 850, 450);
            userViewPanel.setLayout(null);
            userView = new JPanel();
            userView.setBackground(Color.decode("#1E90FF"));
            userView.setLayout(null);
            userView.setBounds(0, 0, 850, 40);
            menubarLabel = new JLabel("Add New Student Details");
            menubarLabel.setBounds(20, 10, 200, 20);
            menubarLabel.setFont(new Font("calibri", Font.PLAIN, 16));
            menubarLabel.setForeground(Color.WHITE);
            userView.add(menubarLabel);
            add(userView);

            regNoLabel = new JLabel("RegNO");
            regNoLabel.setBounds(50, 40, 150, 30);
            regNoLabel.setForeground(Color.decode("#000080"));
            regNoLabel.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(regNoLabel);

            regNoField = new JTextField();
            regNoField.setBounds(200, 40, 200, 30);
            userViewPanel.add(regNoField);
            FName = new JLabel(" first Name  ");
            FName.setBounds(50, 90, 150, 30);
            FName.setForeground(Color.decode("#000080"));
            FName.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(FName);

            FnameField = new JTextField();
            FnameField.setBounds(200, 90, 200, 30);
            userViewPanel.add(FnameField);
            lastNameLabel = new JLabel("  last Name");
            lastNameLabel.setBounds(50, 140, 150, 30);
            userViewPanel.add(lastNameLabel);

            lastNameField = new JTextField();
            lastNameField.setBounds(200, 140, 200, 30);
            userViewPanel.add(lastNameField);
            dob = new JLabel("date Of Birth");
            dob.setBounds(50, 190, 150, 30);
            userViewPanel.add(dob);
            datechooser = new JDateChooser();
            datechooser.setBounds(200, 190, 200, 30);
            datechooser.setBorder( new LineBorder(Color.gray));
            userViewPanel.add(datechooser);
            contactLabel = new JLabel(" contact");
            contactLabel.setBounds(50, 240, 150, 30);
            contactLabel.setForeground(Color.decode("#000080"));
            contactLabel.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(contactLabel);

            contactField = new JTextField();
            contactField.setBounds(200, 240, 200, 30);
            userViewPanel.add(contactField);
            Email = new JLabel(" Email");
            Email.setBounds(50, 290, 150, 30);
            Email.setForeground(Color.decode("#000080"));
            Email.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(Email);

            Emailfield = new JTextField();
            Emailfield.setBounds(200, 290, 200, 30);
            Emailfield.addKeyListener(
                    new KeyListener() {
                        @Override
                        public void keyTyped(KeyEvent e) {
                            passwordfield.setText(Emailfield.getText());
                            confirmPasswordfield.setText(Emailfield.getText());
                            passwordfield.setEditable(false);
                            confirmPasswordfield.setEditable(false);
                        }

                        @Override
                        public void keyPressed(KeyEvent e) {
                        }

                        @Override
                        public void keyReleased(KeyEvent e) {
                        }
                    }
            );
            userViewPanel.add(Emailfield);
            residenceLabel = new JLabel("Residence");
            residenceLabel.setBounds(50, 340, 150, 30);
            residenceLabel.setForeground(Color.decode("#000080"));
            residenceLabel.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(residenceLabel);

            residenceField = new JComboBox(data);
            residenceField.setBounds(200, 340, 200, 30);
            userViewPanel.add(residenceField);
            programmeLabel = new JLabel(" Programme");
            programmeLabel.setBounds(50, 390, 150, 30);
            programmeLabel.setForeground(Color.decode("#000080"));
            programmeLabel.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(programmeLabel);


            password = new JLabel("  password");
            password.setBounds(450, 320, 150, 30);
            password.setForeground(Color.decode("#000080"));
            password.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(password);
            passwordfield = new JPasswordField();
            passwordfield.setBounds(600, 320, 200, 30);
            userViewPanel.add(passwordfield);
            passwordfield.setBorder(new LineBorder(Color.decode("#c0c0c0"), 2, true));
            passwordfield.addFocusListener(
                    new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent ex) {
                            passwordfield.setBorder(new LineBorder(Color.decode("#1E90FF"), 2, true));
                        }

                        @Override
                        public void focusLost(FocusEvent ex) {
                            passwordfield.setBorder(new LineBorder(Color.decode("#c0c0c0"), 2, true));
                        }
                    }
            );

            confirmpasswordLabel = new JLabel("confirm password");
            confirmpasswordLabel.setBounds(450, 370, 150, 30);
            confirmpasswordLabel.setForeground(Color.decode("#000080"));
            confirmpasswordLabel.setFont(new Font("Arial", Font.BOLD, 16));
            userViewPanel.add(confirmpasswordLabel);
            confirmPasswordfield = new JPasswordField();
            confirmPasswordfield.setBounds(600, 370, 200, 30);

            confirmPasswordfield.setBorder(new LineBorder(Color.decode("#c0c0c0"), 2, true));
            confirmPasswordfield.addFocusListener(
                    new FocusListener() {
                        @Override
                        public void focusGained(FocusEvent ex) {
                            confirmPasswordfield.setBorder(new LineBorder(Color.decode("#1E90FF"), 2, true));
                        }

                        @Override
                        public void focusLost(FocusEvent ex) {
                            confirmPasswordfield.setBorder(new LineBorder(Color.decode("#c0c0c0"), 2, true));
                        }
                    }
            );
            userViewPanel.add(confirmPasswordfield);

            programmeField = new JComboBox();
            programmeField.setBounds(200, 390, 200, 30);
            BindComboBox();
            userViewPanel.add(programmeField);

            closeButton = new JButton("Cancel");
            closeButton.setBackground(Color.decode("#ff6600"));
            closeButton.setForeground(Color.WHITE);
            closeButton.setBounds(340, 510, 80, 30);
            closeButton.addActionListener((ActionEvent e) -> {
                dispose();
            });
            add(closeButton);
            saveButton = new JButton("Save");
            saveButton.setBackground(Color.decode("#1e90ff"));
            saveButton.setForeground(Color.WHITE);
            saveButton.setBounds(440, 510, 80, 30);
            saveButton.addActionListener((ActionEvent e) -> {

            });
            add(saveButton);
            List<JTextField> fields = Arrays.asList(contactField, Emailfield,
                    regNoField, FnameField, lastNameField);
            List<JLabel> labels = Arrays.asList(regNoLabel, FName, lastNameLabel, dob, contactLabel, Email, residenceLabel,
                    confirmpasswordLabel, password, programmeLabel);
            TextFieldsPropertiesApi.JTextfieldsProperties(fields);
            LabelPropertiesApi.labelsDeclaration(labels);

            add(userViewPanel);
            setModal(true);
            setVisible(true);

        }

        public static void BindComboBox() {
            Connection conn;
            try {
                conn =  MysqlConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select * FROM Programme");
                while (rs.next()) {
                    programmeField.addItem(rs.getString("programmeName"));
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                        "StudentBOT information Center", JOptionPane.INFORMATION_MESSAGE);
            }

        }

        public static String getProgrammeID(String name) {
            Connection conn;
            try {
                conn = MysqlConnection.connect();
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery("select programmeID FROM programme where programmeName = '"+name+"'");
                while (rs.next()) {
                    programme = rs.getString("ProgrammeID");
                }

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                        "StudentBOT information Center", JOptionPane.INFORMATION_MESSAGE);
            }
            return programme;

        }

    }

