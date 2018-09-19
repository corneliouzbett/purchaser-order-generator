package com.bettkipchumba.java.db;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnection {

    public static java.sql.Connection connect(){
        try {
            Connection connection = DriverManager.getConnection(""
                    + "jdbc:mysql://localhost:3306/procument", "root", "");
            return connection;
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Server Error..... \n Connection Failed",
                    "Belisco Softwares Message Services",JOptionPane.INFORMATION_MESSAGE);

            return null;
        }
    }
}
