package com.bettkipchumba.java.core;
import com.bettkipchumba.java.db.MysqlConnection;
import com.bettkipchumba.java.db.PurchaseOrderDao;
import com.bettkipchumba.java.model.PurchaseOrder;
import com.bettkipchumba.java.utils.pdf.GeneratePurchaseOrderPdf;
import com.toedter.calendar.JDateChooser;

import java.awt.Color;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 *
 * @author Corneliouz Bett
 */
public class PurchaseOrderview extends JPanel {


    private static JMenuBar headMenuBar;
    private static JLabel headLabel;
    private static JTextPane studentLabel;
    private static JScrollPane scrollPane;
    private static JButton addButton;
    private static JButton editButton;
    private static JButton printButton;
    private static JButton deleteButton;

    private static JDateChooser fromDateChooser, toDateChooser;
    private static JPanel viewPanel;

    public PurchaseOrderview() {
        setSize(1050, 800);
        setLayout(null);
        setBackground(Color.WHITE);

        studentLabel = new JTextPane();
        studentLabel.setText("'Learn from yesterday, live for today, "
                + "hope for tomorrow' ------Albert einstein------");
        studentLabel.setFont(new Font("calibri", Font.BOLD, 15));
        studentLabel.setBounds(50, 10, 800, 30);

        viewPanel = new JPanel();
        viewPanel.setBounds(10,10,1010,60);
        viewPanel.setLayout(null);
        viewPanel.setBorder(new LineBorder(Color.decode("#1e90ff"),2,false));

        //add(studentLabel);

        headMenuBar = new JMenuBar();
        headMenuBar.setBounds(10, 70, 1010, 35);
        headMenuBar.setBackground(Color.decode("#1e90ff"));
        headLabel = new JLabel("Purchase reports for the month of september");
        headLabel.setIcon(new ImageIcon(getClass().getResource("images/List.png")));
        headLabel.setForeground(Color.WHITE);
        headLabel.setFont(new Font("calibri", Font.PLAIN, 14));
        headMenuBar.add(headLabel);
        add(headMenuBar);

        scrollPane = new JScrollPane( PurchaseOrderDao.create_Table(),
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        scrollPane.setBounds(10, 105, 1010, 540);
        scrollPane.getViewport().setBackground(Color.WHITE);
        add(scrollPane);

        addButton = new JButton("ADD");
        addButton.setBounds(140, 10, 80, 30);
        addButton.setBackground(Color.decode("#239B56"));
        addButton.setForeground(Color.WHITE);
        addButton.setBorder(new LineBorder(Color.decode("#239B56"),2,true));
        viewPanel.add(addButton);
        editButton = new JButton("EDIT");
        editButton.setBounds(240, 10, 80, 30);
        editButton.setBackground(Color.decode("#F1C40F"));
        editButton.setForeground(Color.WHITE);
        editButton.setBorder(new LineBorder(Color.decode("#F1C40F"),2,true));
        viewPanel.add(editButton);
        deleteButton = new JButton("DELETE");
        deleteButton.setBounds(340, 10, 80, 30);
        deleteButton.setBackground(Color.decode("#C0392B"));
        deleteButton.setForeground(Color.WHITE);
        deleteButton.setBorder(new LineBorder(Color.decode("#C0392B"),2,true));
        viewPanel.add(deleteButton);

        JLabel fromLabel = new JLabel("From ");
        fromLabel.setBounds(450,10,60,30);
        fromDateChooser = new JDateChooser();
        fromDateChooser.setBounds(510, 10, 130, 30);
        viewPanel.add(fromLabel);
        viewPanel.add(fromDateChooser);
        JLabel toLabel = new JLabel("To ");
        toLabel.setBounds(650,10,60,30);
        toDateChooser = new JDateChooser();
        toDateChooser.setBounds(710, 10, 130, 30);
        viewPanel.add(toLabel);
        viewPanel.add(toDateChooser);

        printButton = new JButton("EXPORT TO PDF");
        printButton.setBounds(850, 10, 150, 30);
        printButton.setBackground(Color.decode("#2E86C1"));
        printButton.setForeground(Color.WHITE);
        printButton.setBorder(new LineBorder(Color.decode("#2E86C1"),2,true));
        viewPanel.add(printButton);
        add(viewPanel);

        addButton.addActionListener( e ->{ MainSkeleton.CreateNewSystemView(new AddPurchaseOrderView());});
        editButton.addActionListener( e -> {
            MainSkeleton.CreateNewSystemView(new EditPurchaseOrderView(populateFields(Integer.parseInt(PurchaseOrderDao.GetTablePrimaryKey()))));
        });
        deleteButton.addActionListener( e -> {
            PurchaseOrderDao.deletePurchaseOrder(Integer.parseInt(PurchaseOrderDao.id));
        });
        printButton.addActionListener( e -> new GeneratePurchaseOrderPdf(new Date(fromDateChooser.getDate().getTime()),
                new Date(toDateChooser.getDate().getTime())));

        repaint();
        setVisible(true);

    }
    private PurchaseOrder populateFields(int id){
        Connection conn;
        PurchaseOrder purchaseOrder = new PurchaseOrder();
        try {
            conn = MysqlConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * FROM purchaseorder WHERE id = "+id+"");
            while (rs.next()) {
                purchaseOrder.setLpoNo(rs.getString("LPONo"));
                purchaseOrder.setLpoDate(rs.getDate("LPODate"));
                purchaseOrder.setItemDescription(rs.getString("PurchaseDescription"));
                purchaseOrder.setUnitOfIssue(rs.getString("unitOfIssue"));
                purchaseOrder.setQuantity(rs.getInt("Quantity"));
                purchaseOrder.setUnitPrice(rs.getDouble("unitPrice"));
                purchaseOrder.setTotalPrice(rs.getDouble("totalcost"));
                purchaseOrder.setPl4(rs.getString("pl4"));
                purchaseOrder.setVehicleNo(rs.getString("vehicleNo"));
                purchaseOrder.setDepartment(rs.getString("department"));
                purchaseOrder.setAuthorisedBy(rs.getString("authorisedBy"));
                purchaseOrder.setProcumentMethod(rs.getString("procumentMethod"));
                purchaseOrder.setProcumentMethod(rs.getString("procumentReference"));
                purchaseOrder.setSupplier(rs.getString("supplier"));
                purchaseOrder.setInvoiceNo(rs.getString("invoiceNo"));
                purchaseOrder.setInvoiceNo(rs.getString("invoiceDate"));
                purchaseOrder.setInvoiceNo(rs.getString("invoiceAmount"));
                purchaseOrder.setGRN_NO(rs.getString("schemeApplied"));
                purchaseOrder.setGRN_NO(rs.getString("schemeRegNo"));
                purchaseOrder.setGRN_NO(rs.getString("DeliveryNoteNo"));
                purchaseOrder.setGRN_NO(rs.getString("Status"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
        }
        return purchaseOrder;
    }

}
