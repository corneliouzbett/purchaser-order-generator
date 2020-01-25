package com.bettkipchumba.java.utils.pdf;
import com.bettkipchumba.java.db.MysqlConnection;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;

import javax.swing.*;
import java.sql.*;

public class TableBuilder {
    // create table
    public static PdfPTable createTable(Date start, Date to) throws DocumentException {

        // create 6 column table
        PdfPTable table = new PdfPTable(22);

        // set the width of the table to 100% of page
        table.setWidthPercentage(100);

        // set relative columns width
        //table.setWidths(new float[]{0.6f, 1.4f, 0.8f,0.8f,1.8f,2.6f});

        // ----------------Table Header "Title"----------------
        // font
        Font font = new Font(FontFamily.TIMES_ROMAN, 10, Font.BOLD, BaseColor.BLACK);
        // create header cell
        PdfPCell cell = new PdfPCell(new Phrase("REPORT PURCHASE FOR THE MONTH OF SEPT",font));
        // set Column span "1 cell = 6 cells width"
        cell.setColspan(22);
        // set style
        Style.headerCellStyle(cell);
        // add to table
        table.addCell(cell);

        //-----------------Table Cells Label/Value------------------

        // Table header
        table.addCell(createValueCell("LPODate"));
        table.addCell(createValueCell("item desc"));
        table.addCell(createValueCell("unit of issue"));
        table.addCell(createValueCell("qty"));
        table.addCell(createValueCell("unit price"));
        table.addCell(createValueCell("total cost"));
        table.addCell(createValueCell("Pl4"));
        table.addCell(createValueCell("proc Ref"));
        table.addCell(createValueCell("vehicleNo"));
        table.addCell(createValueCell("dpt"));
        table.addCell(createValueCell("LpoNo"));
        table.addCell(createValueCell("Authorisedby"));
        table.addCell(createValueCell("proc method"));
        table.addCell(createValueCell("supplier"));
        table.addCell(createValueCell("invoice no"));
        table.addCell(createValueCell("invoice date"));
        table.addCell(createValueCell("invoice amount"));
        table.addCell(createValueCell("scheme applied"));
        table.addCell(createValueCell("scheme no"));
        table.addCell(createValueCell("delivery noteNo"));
        table.addCell(createValueCell("status"));
        table.addCell(createValueCell("Quote"));

        Connection conn;
        try {
            conn = MysqlConnection.connect();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("select * FROM purchaseorder WHERE LPODate >= '"+start+"' AND LPODate <= '"+to+"'");
            while (rs.next()) {
                table.addCell(createLabelCell(rs.getString("LPODate")));
                table.addCell(createLabelCell(rs.getString("PurchaseDescription")));
                table.addCell(createLabelCell(rs.getString("unitOfIssue")));
                table.addCell(createLabelCell(rs.getString("Quantity")));
                table.addCell(createLabelCell(rs.getString("unitPrice")));
                table.addCell(createLabelCell(rs.getString("totalcost")));
                table.addCell(createLabelCell(rs.getString("pl4")));
                table.addCell(createLabelCell(rs.getString("procumentReference")));
                table.addCell(createLabelCell(rs.getString("vehicleNo")));
                table.addCell(createLabelCell(rs.getString("department")));
                table.addCell(createLabelCell(rs.getString("LPONo")));
                table.addCell(createLabelCell(rs.getString("authorisedBy")));
                table.addCell(createLabelCell(rs.getString("procumentMethod")));
                table.addCell(createLabelCell(rs.getString("supplier")));
                table.addCell(createLabelCell(rs.getString("invoiceNo")));
                table.addCell(createLabelCell(rs.getString("invoiceDate")));
                table.addCell(createLabelCell(rs.getString("invoiceAmount")));
                table.addCell(createLabelCell(rs.getString("schemeRegNo")));
                table.addCell(createLabelCell(rs.getString("schemeApplied")));
                table.addCell(createLabelCell(rs.getString("DeliveryNoteNo")));
                table.addCell(createLabelCell(rs.getString("Status")));
                table.addCell(createLabelCell(rs.getString("Q")));
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Database Error" + ex.getMessage(),
                    "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
        }

        return table;
    }

    // create cells
    private static PdfPCell createLabelCell(String text){
        // font
        Font font = new Font(FontFamily.TIMES_ROMAN, 7, Font.BOLD, BaseColor.DARK_GRAY);

        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));

        // set style
        Style.labelCellStyle(cell);
        return cell;
    }

    // create cells
    private static PdfPCell createValueCell(String text){
        // font
        Font font = new Font(FontFamily.TIMES_ROMAN, 7, Font.NORMAL, BaseColor.BLACK);

        // create cell
        PdfPCell cell = new PdfPCell(new Phrase(text,font));

        // set style
        Style.tableHeaderCellStyle(cell);
        return cell;
    }
}
