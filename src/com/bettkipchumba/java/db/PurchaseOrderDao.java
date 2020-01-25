package com.bettkipchumba.java.db;

import com.bettkipchumba.java.core.MainSkeleton;
import com.bettkipchumba.java.core.PurchaseOrderview;
import com.bettkipchumba.java.model.PurchaseOrder;
import com.bettkipchumba.java.utils.EvenOddRenderer;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.Vector;

/**
 *
 * @author Corneliouz Bett
 */
public class PurchaseOrderDao {


    static JTable DBTable = null;
    private static JTable table;
    public static String id;
    static int row;


    public static JTable create_Table() {
        try {
            Connection conn = MysqlConnection.connect();
            Statement stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery("select id, LPONo, LPODate,purchaseDescription,Quantity "
                    + ",unitPrice,totalcost, invoiceNo, invoiceDate, invoiceAmount, schemeRegNo, schemeApplied,"
                    + "vehicleNo,department,authorisedBy,supplier,procumentMethod,procumentReference, DeliveryNoteNo, Status FROM purchaseOrder;")) {
                table = new JTable(buildTableModel(rs));
                table.setRowHeight(30);
                table.setBackground(Color.WHITE);
                table.setRowSelectionAllowed(true);
                table.setShowGrid(false);
                TableCellRenderer renderer = new EvenOddRenderer();
                table.setDefaultRenderer(Object.class, renderer);
                table.setForeground(Color.decode("#000000"));
                table.setFont(new Font("calibri", Font.PLAIN, 16));
                table.addMouseListener(
                        new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                row = table.getSelectedRow();
                                int col = table.getSelectedColumn();
                                id = table.getValueAt(row, 0).toString();
                                //JOptionPane.showMessageDialog(null,table.getValueAt(row, 0).toString());
                            }
                        }
                );
            }
            DBTable = table;

        } catch (SQLException | HeadlessException exc) {
            JOptionPane.showMessageDialog(null, exc);
        }
        return DBTable;
    }

    public static DefaultTableModel buildTableModel(ResultSet rs)
            throws SQLException {

        ResultSetMetaData metaData = rs.getMetaData();

        // names of columns
        Vector<String> columnNames = new Vector<>();
        int columnCount = metaData.getColumnCount();
        for (int column = 1; column <= columnCount; column++) {
            columnNames.add(metaData.getColumnName(column));
        }

        // data of the table
        Vector<Vector<Object>> data = new Vector<>();
        while (rs.next()) {
            Vector<Object> vector = new Vector<>();
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                vector.add(rs.getObject(columnIndex));
            }
            data.add(vector);
        }

        return new DefaultTableModel(data, columnNames);

    }
    public final static void addPurchaseOrder(PurchaseOrder purchaseOrder){
        try
        {
            Connection connection = MysqlConnection.connect() ;
            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO  purchaseorder VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1, 0);
            preparedStatement.setDate(2, purchaseOrder.getLpoDate());
            preparedStatement.setString(3, purchaseOrder.getItemDescription());
            preparedStatement.setString(4, purchaseOrder.getUnitOfIssue());
            preparedStatement.setInt(5, purchaseOrder.getQuantity());
            preparedStatement.setDouble(6, purchaseOrder.getUnitPrice());
            preparedStatement.setDouble(7, purchaseOrder.getTotalPrice());
            preparedStatement.setString(8, purchaseOrder.getPl4());
            preparedStatement.setString(9, purchaseOrder.getProcumentReference());
            preparedStatement.setString(10, purchaseOrder.getVehicleNo());
            preparedStatement.setString(11, purchaseOrder.getDepartment());
            preparedStatement.setString(12, purchaseOrder.getLpoNo());
            preparedStatement.setString(13, purchaseOrder.getAuthorisedBy());
            preparedStatement.setString(14, purchaseOrder.getProcumentMethod());
            preparedStatement.setString(15, purchaseOrder.getSupplier());
            preparedStatement.setString(16, purchaseOrder.getInvoiceNo());
            preparedStatement.setString(17, purchaseOrder.getGRN_NO());
            preparedStatement.setDate(18, purchaseOrder.getInvoiceDate());
            preparedStatement.setString(19, purchaseOrder.getInvoiceAmount());
            preparedStatement.setString(20, purchaseOrder.getSchemeApplied());
            preparedStatement.setString(21, purchaseOrder.getSchemeRegNo());
            preparedStatement.setString(22, purchaseOrder.getDeliveryNoteNo());
            preparedStatement.setString(23, purchaseOrder.getStatus());
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Purchase Order Added Successfully", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DB ERROR" + e.getMessage(), "Belisco Softwares Message Service", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static final void deletePurchaseOrder(int id) {

        try {
            Connection connection = MysqlConnection.connect();
            connection.setAutoCommit(false);
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM purchaseorder WHERE id IN(?)");
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to delete", "Belisco Softwares Message Service", JOptionPane.YES_NO_CANCEL_OPTION);
            switch (option) {
                case JOptionPane.NO_OPTION:
                    connection.rollback();
                    JOptionPane.showMessageDialog(null, "Delete Cancelled", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case JOptionPane.YES_OPTION:
                    connection.commit();
                    MainSkeleton.CreateNewSystemView(new PurchaseOrderview());
                    JOptionPane.showMessageDialog(null, "Delete successfull", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                    break;
                case JOptionPane.CANCEL_OPTION:
                    connection.rollback();
                    JOptionPane.showMessageDialog(null, "Delete Cancelled", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "An unexpected error occured", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
                    break;
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DB ERROR" + e.getMessage(), "Belisco Softwares Message Service", JOptionPane.WARNING_MESSAGE);
        }
    }

    public static final void updatePurchaseOrder(PurchaseOrder purchaseOrder, int id) {

        try
        {
            Connection connection =MysqlConnection.connect() ;
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE  purchaseorder "
                    + "SET PurchaseDescription = ? , unitOfIssue= ?,"
                    + " Quantity = ?, unitPrice = ?, totalcost = ?, pl4 = ?,"
                    + " requestby = ?, vehicleNo = ?, department = ?,  LPONo = ?, authorisedBy = ?, procumentMethod = ?, supplier = ? , invoiceNo = ?, Q = ?, LPODate = ? WHERE id = ? ;");
            preparedStatement.setString(1, purchaseOrder.getItemDescription());
            preparedStatement.setString(2, purchaseOrder.getUnitOfIssue());
            preparedStatement.setInt(3, purchaseOrder.getQuantity());
            preparedStatement.setDouble(4, purchaseOrder.getUnitPrice());
            preparedStatement.setDouble(5, purchaseOrder.getTotalPrice());
            preparedStatement.setString(6, purchaseOrder.getPl4());
            preparedStatement.setString(7, purchaseOrder.getRequestBy());
            preparedStatement.setString(8, purchaseOrder.getVehicleNo());
            preparedStatement.setString(9, purchaseOrder.getDepartment());
            preparedStatement.setString(10, purchaseOrder.getLpoNo());
            preparedStatement.setString(11, purchaseOrder.getAuthorisedBy());
            preparedStatement.setString(12, purchaseOrder.getProcumentMethod());
            preparedStatement.setString(13, purchaseOrder.getSupplier());
            preparedStatement.setString(14, purchaseOrder.getInvoiceNo());
            preparedStatement.setString(15, purchaseOrder.getGRN_NO());
            preparedStatement.setDate(16, purchaseOrder.getLpoDate());
            preparedStatement.setInt(17, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Update purchase Order successfull", "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "DB ERROR" + e.getMessage(), "Belisco Softwares Message Service", JOptionPane.WARNING_MESSAGE);
        }
    }
    public static String GetTablePrimaryKey() {
        return table.getValueAt(row, 0).toString();
    }
}
