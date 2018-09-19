package com.bettkipchumba.java.core;

import com.bettkipchumba.java.api.LabelPropertiesApi;
import com.bettkipchumba.java.api.TextFieldsPropertiesApi;
import com.bettkipchumba.java.db.MysqlConnection;
import com.bettkipchumba.java.db.PurchaseOrderDao;
import com.bettkipchumba.java.model.PurchaseOrder;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AddPurchaseOrderView extends JPanel {
    private static JPanel userView, userViewPanel;
    private static JLabel menubarLabel;
    private static JLabel lpoDateLabel, purchaseDescLabel,unitofissueLabel,quantitylabel,unitCostlabel,pl4label,requestbylabel,
    vehiclenoLabel,departmentlabel,lponolabel,authorisedbylabel,procumentmethod,supplierlabel,invoicenolabel;
    private static JTextField  purchaseDescTextArea,unitofissue,quantity,unitcost,pl4,requestedby,vehicleno,lpono,authoriseby,invoiceno;
    private static JComboBox departmentcombo,procumentMethodcombo, suppliercombo;

    private static JButton backButton, submitButton;
    private static JDateChooser lpoDateField;

    String [] procumentMethods = {"Quotation","Contract","Profoma","Cash purchase","Tender"};


    public AddPurchaseOrderView() {
        setSize(1050, 800);
        setLayout(null);
       // setBackground(Color.WHITE);

        userViewPanel = new JPanel();
        userViewPanel.setBackground(Color.WHITE);
        userViewPanel.setBounds(50, 30, 950, 600);
        userViewPanel.setBorder(new LineBorder(Color.decode("#1e90ff")));
        userViewPanel.setLayout(null);

        userView = new JPanel();
        userView.setBackground(Color.decode("#1E90FF"));
        userView.setLayout(null);
        userView.setBounds(0, 0, 950, 40);
        menubarLabel = new JLabel(" ADD NEW PURCHASE ORDER DETAILS");
        menubarLabel.setBounds(20, 10, 400, 20);
        menubarLabel.setFont(new Font("calibri", Font.PLAIN, 16));
        menubarLabel.setForeground(Color.WHITE);
        userView.add(menubarLabel);
        userViewPanel.add(userView);

        lpoDateLabel = new JLabel("LPO Date");
        lpoDateLabel.setBounds(20,70,150,20);
        userViewPanel.add(lpoDateLabel);
        lpoDateField = new JDateChooser();
        lpoDateField.setBounds(230,70,200,30);
        userViewPanel.add(lpoDateField);

        purchaseDescLabel = new JLabel("Purchase Description");
        purchaseDescLabel.setBounds(20,120,150,20);
        userViewPanel.add(purchaseDescLabel);
        purchaseDescTextArea = new JTextField();
        purchaseDescTextArea.setBorder(new LineBorder(Color.DARK_GRAY));
        purchaseDescTextArea.setBounds(230,120,200,40);
        userViewPanel.add(purchaseDescTextArea);

        unitofissueLabel = new JLabel("Unit of Issue");
        unitofissueLabel.setBounds(20,180,200,20);
        userViewPanel.add(unitofissueLabel);
        unitofissue = new JTextField();
        unitofissue.setBounds(230,180,200,30);
        userViewPanel.add(unitofissue);

        quantitylabel = new JLabel("Quantity");
        quantitylabel.setBounds(20,230,200,20);
        userViewPanel.add(quantitylabel);
        quantity = new JTextField();
        quantity.setBounds(230,230,200,30);
        userViewPanel.add(quantity);

        unitCostlabel = new JLabel("Unit Cost");
        unitCostlabel.setBounds(20,280,200,20);
        userViewPanel.add(unitCostlabel);
        unitcost = new JTextField();
        unitcost.setBounds(230,280,200,30);
        userViewPanel.add(unitcost);

        pl4label = new JLabel("PL0 4");
        pl4label.setBounds(20,330,200,20);
        userViewPanel.add(pl4label);
        pl4 = new JTextField();
        pl4.setBounds(230,330,200,30);
        userViewPanel.add(pl4);

        requestbylabel = new JLabel("Request By");
        requestbylabel.setBounds(20,380,200,20);
        userViewPanel.add(requestbylabel);
        requestedby = new JTextField();
        requestedby.setBounds(230,380,200,30);
        userViewPanel.add(requestedby);

        vehiclenoLabel = new JLabel("Vehicle No");
        vehiclenoLabel.setBounds(20,430,200,20);
        userViewPanel.add(vehiclenoLabel);
        vehicleno = new JTextField();
        vehicleno.setBounds(230,430,200,30);
        userViewPanel.add(vehicleno);

        departmentlabel = new JLabel("Department");
        departmentlabel.setBounds(500,70,150,20);
        userViewPanel.add(departmentlabel);
        departmentcombo = new JComboBox();
        departmentcombo.setBounds(630,70,200,30);
        userViewPanel.add(departmentcombo);

        lponolabel = new JLabel("LPO Number");
        lponolabel.setBounds(500,120,150,20);
        userViewPanel.add(lponolabel);
        lpono = new JTextField();
        lpono.setBounds(630,120,200,40);
        userViewPanel.add(lpono);

        authorisedbylabel = new JLabel("Authorised By");
        authorisedbylabel.setBounds(500,180,200,20);
        userViewPanel.add(authorisedbylabel);
        authoriseby = new JTextField();
        authoriseby.setBounds(630,180,200,30);
        userViewPanel.add(authoriseby);

        procumentmethod = new JLabel("Procument method");
        procumentmethod.setBounds(500,230,200,20);
        userViewPanel.add(procumentmethod);
        procumentMethodcombo = new JComboBox(procumentMethods);
        procumentMethodcombo.setBounds(630,230,200,30);
        userViewPanel.add(procumentMethodcombo);

        supplierlabel = new JLabel("Supplier");
        supplierlabel.setBounds(500,280,200,20);
        userViewPanel.add(supplierlabel);
        suppliercombo = new JComboBox();
        suppliercombo.setBounds(630,280,200,30);
        userViewPanel.add(suppliercombo);

        invoicenolabel = new JLabel("Invoice Number");
        invoicenolabel.setBounds(500,330,200,20);
        userViewPanel.add(invoicenolabel);
        invoiceno = new JTextField();
        invoiceno.setBounds(630,330,200,30);
        userViewPanel.add(invoiceno);
        BindDepartmentComboBox();
        BindSupplierComboBox();

        backButton = new JButton("BACK");
        backButton.setBounds(450, 530, 100, 30);
        backButton.setBackground(Color.decode("#2E86C1"));
        backButton.setForeground(Color.WHITE);
        backButton.setBorder(new LineBorder(Color.decode("#2E86C1"),2,true));
        add(backButton);
        submitButton = new JButton("SUBMIT");
        submitButton.setBounds(580, 530, 100, 30);
        submitButton.setBackground(Color.decode("#2E86C1"));
        submitButton.setForeground(Color.WHITE);
        submitButton.setBorder(new LineBorder(Color.decode("#2E86C1"),2,true));

        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to leave this view", "Belisco Softwares Message Service", JOptionPane.YES_NO_CANCEL_OPTION);
                switch (option) {
                    case JOptionPane.NO_OPTION:
                        JOptionPane.showMessageDialog(null, "Cancelled", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    case JOptionPane.YES_OPTION:
                        MainSkeleton.CreateNewSystemView(new PurchaseOrderview());
                        break;
                    case JOptionPane.CANCEL_OPTION:
                        JOptionPane.showMessageDialog(null, "Cancelled", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                        break;
                    default:
                        JOptionPane.showMessageDialog(null, "An unexpected error occured", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            }
        });

        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ( !purchaseDescTextArea.getText().isEmpty() && !authoriseby.getText().isEmpty() &&
                        !lpono.getText().isEmpty() && !vehicleno.getText().isEmpty() && !requestedby.getText().isEmpty() && !pl4.getText().isEmpty()
                        && !unitcost.getText().isEmpty() && !quantity.getText().isEmpty() && !unitofissue.getText().isEmpty()){
                    PurchaseOrder purchaseOrder = new PurchaseOrder();
                    purchaseOrder.setLpoDate(new Date(lpoDateField.getDate().getTime()));
                    purchaseOrder.setPurchaseDescription(purchaseDescTextArea.getText());
                    purchaseOrder.setUnitOfIssue(unitofissue.getText());
                    purchaseOrder.setQuantity(Integer.parseInt(quantity.getText()));
                    purchaseOrder.setUnitPrice(Double.parseDouble(unitcost.getText()));
                    purchaseOrder.setTotalPrice(Double.parseDouble(unitcost.getText()) * Double.parseDouble(quantity.getText()));
                    purchaseOrder.setPl4(pl4.getText());
                    purchaseOrder.setRequestBy(requestedby.getText());
                    purchaseOrder.setVehicleNo(vehicleno.getText());
                    purchaseOrder.setDepartment(departmentcombo.getSelectedItem().toString());
                    purchaseOrder.setLpoNo(lpono.getText());
                    purchaseOrder.setAuthorisedBy(authoriseby.getText());
                    purchaseOrder.setProcumentMethod(procumentMethodcombo.getSelectedItem().toString());
                    purchaseOrder.setSupplier(suppliercombo.getSelectedItem().toString());
                    purchaseOrder.setInvoiceNo(invoiceno.getText());
                    purchaseOrder.setQteNO("");
                    PurchaseOrderDao.addPurchaseOrder(purchaseOrder);
                } else {
                    validateView();
                }

            }
        });

        add(submitButton);


        java.util.List<JTextField> fields = Arrays.asList(purchaseDescTextArea, unitofissue,quantity,unitcost,pl4,requestedby,vehicleno,lpono,authoriseby,invoiceno);
        List<JLabel> labels = Arrays.asList(lpoDateLabel, purchaseDescLabel,unitofissueLabel,quantitylabel,unitCostlabel,pl4label,requestbylabel,
                vehiclenoLabel,departmentlabel,lponolabel,authorisedbylabel,procumentmethod,supplierlabel,invoicenolabel);
        TextFieldsPropertiesApi.JTextfieldsProperties(fields);
        LabelPropertiesApi.labelsDeclaration(labels);

        add(userViewPanel);
        repaint();
        setVisible(true);

    }
     boolean validateView(){
        boolean isValid = false;
        if(purchaseDescTextArea.getText().isEmpty()){
            purchaseDescTextArea.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (unitofissue.getText().isEmpty()){
            unitofissue.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (quantity.getText().isEmpty()){
            quantity.setBorder(new LineBorder(Color.RED));
            isValid = false;
        }
        else if (unitcost.getText().isEmpty()){
            unitcost.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (pl4.getText().isEmpty()){
            pl4.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (requestedby.getText().isEmpty()){
            requestedby.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (vehicleno.getText().isEmpty()){
            vehicleno.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (lpono.getText().isEmpty()){
            lpono.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (authoriseby.getText().isEmpty()){
            authoriseby.setBorder(new LineBorder(Color.RED));
            isValid = false;
        } else if (invoiceno.getText().isEmpty()) {
            invoiceno.setBorder(new LineBorder(Color.RED));
            isValid = false;
        }

        return isValid;
    }

    public static void BindSupplierComboBox() {
        Connection conn;
        try {
            conn = MysqlConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * FROM suppliers");
            while (rs.next()) {
                suppliercombo.addItem(rs.getString("name"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
        }

    }
    public static void BindDepartmentComboBox() {
        Connection conn;
        try {
            conn = MysqlConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * FROM department");
            while (rs.next()) {
                departmentcombo.addItem(rs.getString("name"));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
        }

    }
}
