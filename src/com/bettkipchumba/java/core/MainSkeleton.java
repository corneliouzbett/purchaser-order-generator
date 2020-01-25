package com.bettkipchumba.java.core;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.List;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author CorneliouzBett
 */
public class MainSkeleton extends JFrame {
    private static JSplitPane splitpane;
    private static JMenuBar headerManuBar;
    private static JMenu NotificationMenu;
    private static JMenu MessagesMenu;
    private static JMenu userMenu;
    private static JMenuItem logoutMenuItem;
    private static JMenuItem settingsMenuItem;
    private static JMenuItem aboutMenuItem;
    private static JLabel headerlabel;
    private static JMenuBar ImageView;
    private static JMenu imageViewLabel;
    private static JLabel NavBackground;
    private static JButton dashboard;
    private static JButton purchaseorders;
    private static JButton departments;
    private static JButton suppliers;
    private static JButton inventory;
    private static JButton students;
    private static JButton lecturer;
    private static JButton results;
    private static JButton notification;
    private static JButton settings;
    private static JButton Help;
    private static JPanel panel;
    private static String whiteSpace = "  ";

    public MainSkeleton(String user) throws IOException {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1250, 750);
        setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);
        setTitle("Purchase Orders mgt (c) beliscosoftwares @2018");
        URL url = getClass().getResource("images/dome.png");
        ImageIcon img = new ImageIcon(url);
        setIconImage(img.getImage());

        add(CreateHeader("#3498DB", user, "~~ ... ~~"));
        splitpane = new JSplitPane();
        splitpane.setDividerLocation(200);
        splitpane.setDividerSize(1);
        splitpane.setOrientation(JSplitPane.HORIZONTAL_SPLIT);
        splitpane.setBounds(0, 40, 1250, 680);
        splitpane.setEnabled(false);
        splitpane.setBackground(Color.decode("#E6EAED"));
        splitpane.setBorder(new LineBorder(Color.decode("#3498DB")));
        splitpane.setRightComponent(new Dashboard());
        splitpane.setLeftComponent(NavigationDrawer(""));

        add(splitpane);
        repaint();
        setVisible(true);

    }

    public static final void CreateNewSystemView(JPanel NewSystemView) {

        splitpane.remove(splitpane.getRightComponent());
        splitpane.setRightComponent(NewSystemView);
        splitpane.setDividerLocation(200);
        splitpane.setDividerSize(1);
    }

    public JMenuBar CreateHeader(String color, String Username, String ViewName) {

        headerManuBar = new JMenuBar();
        headerManuBar.setBackground(Color.decode(color));
        headerManuBar.setBounds(0, 0, 1250, 40);
        headerManuBar.setLayout(null);

        NotificationMenu = new JMenu();
        MessagesMenu = new JMenu();
        userMenu = new JMenu(Username);
        aboutMenuItem = new JMenuItem("  about                                   ");
        settingsMenuItem = new JMenuItem("  settings                          ");
        logoutMenuItem = new JMenuItem("  log out                         ");
        userMenu.setIcon(new ImageIcon(getClass().getResource("images/user.png")));
        NotificationMenu.setBounds(920, 5, 40, 30);
        MessagesMenu.setBounds(970, 5, 40, 30);
        userMenu.setBounds(1020, 5, 210, 30);
        userMenu.add(settingsMenuItem);
        userMenu.insertSeparator(1);
        userMenu.add(aboutMenuItem);
        userMenu.add(logoutMenuItem);

        logoutMenuItem.addActionListener(logout ->{new Launcher();dispose();});

        headerlabel = new JLabel(ViewName);
        headerlabel.setBounds(500, 3, 400, 40);
        headerlabel.setForeground(Color.WHITE);
        headerlabel.setFont(new Font("calibri", Font.PLAIN, 24));

        List<JMenu> menus = Arrays.asList(NotificationMenu, MessagesMenu, userMenu);
        StyleMenus(menus, color);
        headerManuBar.removeAll();
        headerManuBar.add(headerlabel);
        headerManuBar.add(userMenu);
        repaint();
        add(headerManuBar);
        return headerManuBar;
    }

    private static void StyleMenus(List<JMenu> Menus, String color) {
        Menus.stream()
                .forEach(menu -> {
                    menu.setBackground(Color.decode(color));
                    menu.setBorder(new LineBorder(Color.decode(color)));
                    menu.setForeground(Color.WHITE);
                    menu.setFont(new Font("calibri", Font.PLAIN, 14));
                    menu.addMouseListener(new MouseListener() {
                        @Override
                        public void mouseClicked(MouseEvent e) {
                            menu.setBackground(Color.decode("#154360"));
                        }

                        @Override
                        public void mousePressed(MouseEvent e) {
                        }

                        @Override
                        public void mouseReleased(MouseEvent e) {
                        }

                        @Override
                        public void mouseEntered(MouseEvent e) {
                            menu.setBackground(Color.decode("#9B59B6"));
                        }

                        @Override
                        public void mouseExited(MouseEvent e) {
                            menu.setBackground(Color.decode(color));
                        }
                    });
                });
    }

    public JPanel NavigationDrawer(String user) {
        panel = new JPanel();

        panel.setSize(200, 680);
        //panel.setBackground(Color.lightGray);
        panel.setLayout(null);

        ImageView = new JMenuBar();
        ImageView.setBounds(0, 0, 200, 120);
        ImageView.setLayout(null);
        imageViewLabel = new JMenu(user);
        imageViewLabel.setForeground(Color.decode("#1349B4"));
        imageViewLabel.setFont(new Font("calibri", Font.ITALIC, 14));
        imageViewLabel.setBounds(20, 40, 160, 40);
        ImageView.add(imageViewLabel);
        NavBackground = new JLabel();
        NavBackground.setIcon(new ImageIcon(getClass().
                getResource("images/nav_background.png")));
        NavBackground.setBounds(0, 0, 200, 120);
        ImageView.add(NavBackground);
        panel.add(ImageView);

        dashboard = new JButton(whiteSpace + "Dashboard" + whiteSpace);
        purchaseorders = new JButton(whiteSpace + "++ purchaseOrders ");
        departments = new JButton(whiteSpace + "Departments");
        suppliers = new JButton(whiteSpace + "Supply Chain");
        inventory = new JButton(whiteSpace + "Inventory mgnt");
        students = new JButton(whiteSpace + "Students");
        lecturer = new JButton(whiteSpace + "Lecturers");
        results = new JButton(whiteSpace + "Results");
        notification = new JButton(whiteSpace + "Exit");
        settings = new JButton(whiteSpace + "Settings");
        Help = new JButton(whiteSpace + "Help");
        dashboard.setBounds(0, 120, 200, 50);
        purchaseorders.setBounds(0, 170, 200, 50);
        departments.setBounds(0, 220, 200, 50);
        suppliers.setBounds(0, 270, 200, 50);
        inventory.setBounds(0, 320, 200, 50);
        students.setBounds(0, 370, 200, 50);
        lecturer.setBounds(0, 420, 200, 50);
        results.setBounds(0, 470, 200, 50);
        notification.setBounds(0, 520, 200, 50);
        settings.setBounds(0, 570, 200, 50);
        Help.setBounds(0, 620, 200, 50);

        dashboard.setIcon(new ImageIcon(getClass().getResource("images/Dashboard.png")));
        purchaseorders.setIcon(new ImageIcon(getClass().getResource("images/Events.png")));
        departments.setIcon(new ImageIcon(getClass().getResource("images/DOT.png")));
        suppliers.setIcon(new ImageIcon(getClass().getResource("images/DOT.png")));
        inventory.setIcon(new ImageIcon(getClass().getResource("images/course.png")));
        students.setIcon(new ImageIcon(getClass().getResource("images/folder.png")));
        lecturer.setIcon(new ImageIcon(getClass().getResource("images/folder.png")));
        results.setIcon(new ImageIcon(getClass().getResource("images/folder.png")));
        notification.setIcon(new ImageIcon(getClass().getResource("images/notification.png")));
        settings.setIcon(new ImageIcon(getClass().getResource("images/settings.png")));
        Help.setIcon(new ImageIcon(getClass().getResource("images/user.png")));

        List<JButton> sidePaneItems = Arrays.asList(dashboard, purchaseorders);
        SidePaneItemsProperties(sidePaneItems);

        // switching mechanism
        dashboard.addActionListener(e -> {
                MainSkeleton.CreateNewSystemView(new Dashboard());
        });
        purchaseorders.addActionListener(switchmech -> {
            MainSkeleton.CreateNewSystemView(new PurchaseOrderview());

        });
        departments.addActionListener(switchmech -> {

            MainSkeleton.CreateNewSystemView(new JPanel());
        });
        suppliers.addActionListener(switchmech -> {
            MainSkeleton.CreateNewSystemView(new JPanel());
        });
        inventory.addActionListener(switchmech -> {
            MainSkeleton.CreateNewSystemView(new JPanel());
        });

        panel.repaint();
        panel.setVisible(true);
        return panel;
    }

    private void SidePaneItemsProperties(List<JButton> sidePaneItems) {
        {
            sidePaneItems.stream()
                    .forEach(sidenavItems -> {
                        sidenavItems.setForeground(Color.DARK_GRAY);
                        sidenavItems.setBackground(Color.decode("#E6EAED"));
                        sidenavItems.setFont(new Font("serif", Font.BOLD, 14));
                        sidenavItems.setBorder(new LineBorder(Color.decode("#E6EAED")));
                        sidenavItems.setAlignmentX(LEFT_ALIGNMENT);
                        sidenavItems.setHorizontalAlignment(SwingConstants.LEFT);
                        sidenavItems.addMouseListener(
                                new MouseListener() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                sidenavItems.setBackground(Color.decode("#093CA4"));
                                sidenavItems.setForeground(Color.WHITE);
                                setCursor(new Cursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mousePressed(MouseEvent e) {
                            }

                            @Override
                            public void mouseReleased(MouseEvent e) {
                                sidenavItems.setBackground(Color.decode("#E6EAED"));
                                sidenavItems.setForeground(Color.DARK_GRAY);
                                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            }

                            @Override
                            public void mouseEntered(MouseEvent e) {
                                sidenavItems.setBackground(Color.decode("#3498DB"));
                                sidenavItems.setForeground(Color.WHITE);
                                setCursor(new Cursor(Cursor.HAND_CURSOR));
                            }

                            @Override
                            public void mouseExited(MouseEvent e) {
                                sidenavItems.setBackground(Color.decode("#E6EAED"));
                                sidenavItems.setForeground(Color.DARK_GRAY);
                                setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
                            }
                        }
                        );
                        panel.add(sidenavItems);
                    });

        }
    }

    public static int get_the_department() {
        int value = 0;
        Connection conn;
        try {
            conn = DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/student_assistant", "root", "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(departmentID) FROM department");
            while (rs.next()) {
                value = rs.getInt(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "StudentBOT information Center", JOptionPane.INFORMATION_MESSAGE);
        }
        return value;

    }
    public static int get_the_programme() {
        int value = 0;
        Connection conn;
        try {
            conn = DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/student_assistant", "root", "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(programmeID) FROM suppliers");
            while (rs.next()) {
                value = rs.getInt(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "StudentBOT information Center", JOptionPane.INFORMATION_MESSAGE);
        }
        return value;

    }
    public static int get_the_lecturer() {
        int value = 0;
        Connection conn;
        try {
            conn = DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/student_assistant", "root", "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(lecturerID) FROM lecturer");
            while (rs.next()) {
                value = rs.getInt(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "StudentBOT information Center", JOptionPane.INFORMATION_MESSAGE);
        }
        return value;

    }
    public static int get_the_students() {
        int value = 0;
        Connection conn;
        try {
            conn = DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/student_assistant", "root", "");

            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select count(regno) FROM student");
            while (rs.next()) {
                value = rs.getInt(1);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "StudentBOT information Center", JOptionPane.INFORMATION_MESSAGE);
        }
        return value;

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    MainSkeleton launcher = new MainSkeleton("admin");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
