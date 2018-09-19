package com.bettkipchumba.java.core;

import com.bettkipchumba.java.api.LabelPropertiesApi;
import com.bettkipchumba.java.api.TextFieldsPropertiesApi;
import com.bettkipchumba.java.db.MysqlConnection;
import com.bettkipchumba.java.utils.PasswordEncryptor;

import java.awt.Color;
import java.awt.Font;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

/**
 *
 * @author bettkipchumba Bett
 */
public class Launcher extends JFrame {

    private static JPanel loginPanel;
    private static JPanel LinePanel;
    private static JLabel backgroundImageLabel;
    private static JLabel EmailAddressLabel;
    private static JLabel PasswordLabel;
    private static JPasswordField passwordField;
    private static JTextField EmailAddressField;
    private static JMenuBar menubar;
    private static JButton submitButton;
    private static JPanel LeftPanel;
    private static JLabel created;
    private static JLabel ad;
    private static JLabel da;
    
    private static final int AUTHENTICATION_FAILED = -1;
    private static final int AUTHENTICATION_SUCCESSFULL = 1;
    private static final int AN_UNEXPECTED_ERROR_OCCURRED = 0;

    public Launcher() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setSize(1000, 700);
        setResizable(false);
        setLocationRelativeTo(null);
        setTitle("Procument management System [ Version 1.0.0 ]");

        URL url = getClass().getResource("images/belisco.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());

        menubar = new JMenuBar();
        menubar.setBackground(Color.decode("#1E90FF"));
        menubar.setBounds(0, 0, 1000, 40);
        loginPanel = new JPanel();
        loginPanel.setLayout(null);
        loginPanel.setBounds(350, 120, 400, 320);
        loginPanel.setBackground(color(50));
        LinePanel = new JPanel();
        LinePanel.setBounds(0, 0, 400, 5);
        LinePanel.setBackground(Color.decode("#1E90ff"));
        loginPanel.add(LinePanel);
        EmailAddressLabel = new JLabel("Username");
        EmailAddressLabel.setFont(new Font("serif", Font.BOLD, 18));
        EmailAddressLabel.setBounds(50, 30, 300, 20);
        PasswordLabel = new JLabel("Password");
        PasswordLabel.setFont(new Font("serif", Font.BOLD, 18));
        PasswordLabel.setBounds(50, 120, 300, 20);
        PasswordLabel.setForeground(Color.decode("#000080"));
        PasswordLabel.setFont(new Font("calibri", Font.BOLD, 14));
        EmailAddressLabel.setForeground(Color.decode("#000080"));
        EmailAddressLabel.setFont(new Font("calibri", Font.BOLD, 14));
        EmailAddressField = new JTextField();
        EmailAddressField.setFont(new Font("calibri", Font.ITALIC, 16));
        EmailAddressField.setBounds(50, 60, 300, 40);
        passwordField = new JPasswordField();
        passwordField.setBounds(50, 150, 300, 40);
        submitButton = new JButton("Login");
        submitButton.setBounds(100, 210, 200, 40);
        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(Color.decode("#1E90FF"));
        submitButton.setBorder(new LineBorder(Color.decode("#1E90Ff"), 2, true));

        loginPanel.add(EmailAddressField);
        loginPanel.add(EmailAddressLabel);
        loginPanel.add(passwordField);
        loginPanel.add(PasswordLabel);
        loginPanel.add(submitButton);
        LeftPanel = new JPanel();
        LeftPanel.setLayout(null);
        LeftPanel.setBounds(350, 450, 400, 100);
        LeftPanel.setBackground(color(50));

        created = new JLabel("  Created by corneliouzBett-@kipchumba");
        created.setForeground(Color.decode("#000080"));
        created.setFont(new Font("calibri", Font.BOLD, 14));
        created.setBounds(20, 10, 380, 20);
        LeftPanel.add(created);
        ad = new JLabel("@Copyright 2016 belisco Softwares");
        ad.setForeground(Color.decode("#000080"));
        ad.setFont(new Font("calibri", Font.PLAIN, 12));
        ad.setBounds(30, 40, 380, 20);
        LeftPanel.add(ad);
        da = new JLabel(" All rights reserved");
        da.setForeground(Color.decode("#000080"));
        da.setFont(new Font("calibri", Font.PLAIN, 12));
        da.setBounds(40, 70, 380, 20);
        LeftPanel.add(da);

        List<JTextField> textFields = Arrays.asList(EmailAddressField, passwordField);
        TextFieldsPropertiesApi.JTextfieldsProperties(textFields);
        add(menubar);
        add(loginPanel);
        //add(LeftPanel);
        backgroundImageLabel = new JLabel();
        backgroundImageLabel.setIcon(new ImageIcon(getClass().getResource(
                "images/login_background.jpg")));
        backgroundImageLabel.setBounds(0, 0, 1000, 750);
        add(backgroundImageLabel);
        
        submitButton.addActionListener( e -> {
        Userauthentication(PasswordEncryptor.encryptPassword(String.valueOf(passwordField.getPassword())),
                EmailAddressField.getText());
        });
        
        repaint();
        setVisible(true);
    }

    public static Color color(double val) {
        double H = val * 0.5;
        double S = 0.3;
        double B = 0.9;
        int rgb = Color.HSBtoRGB((float) H, (float) S, (float) B);
        int red = rgb & 0xFF;
        int green = (rgb >> 16) & 0XFF;
        int blue = (rgb >> 8) & 0xFF;
        Color color = new Color(red, green, blue, 0x50);
        return color;

    }

    public final void registerLoggedInUser(String email) {
        try  {
            Connection connection = MysqlConnection.connect();
            Statement statement = connection.createStatement();
            statement.execute("INSERT INTO users_logs  VALUES(0,'" + email + "','"+LocalTime.now()+"','"+LocalDate.now()+"')");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());

        }
    }

    public final int Userauthentication(String enteredPasswordHashed, String emailAddress) {

        String password = "";

        //obtain user password cipher
        try (Connection connection = MysqlConnection.connect()) {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT Password FROM system_user WHERE Email IN(?);");
            preparedStatement.setString(1, emailAddress);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                password = resultSet.getString(1);
            }

            if (enteredPasswordHashed.equals(password)) {
                // authentication succefull.
                JOptionPane.showMessageDialog(null, "Authentication successful",
                        "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                 registerLoggedInUser(emailAddress);
                try {
                    MainSkeleton repositoryApp = new MainSkeleton(emailAddress);
                } catch (IOException ex) {
                    Logger.getLogger(Launcher.class.getName()).log(Level.SEVERE, null, ex);
                }
                dispose();
                return AUTHENTICATION_SUCCESSFULL;

            } else if (!enteredPasswordHashed.equals(password)) {
                //authetication failed
                JOptionPane.showMessageDialog(null, "WRONG PASSWORD OR USERNAME !",
                        "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                return AUTHENTICATION_FAILED;
            } else {
                JOptionPane.showMessageDialog(null, "An unexpected error occurred",
                        "Belisco Softwares Message Service", JOptionPane.ERROR_MESSAGE);
                return AN_UNEXPECTED_ERROR_OCCURRED;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, ":Could't connect to database" + e.getMessage(),
                    "Belisco Softwares Message Service", JOptionPane.ERROR_MESSAGE);
            return 0;
        }
    }
}
