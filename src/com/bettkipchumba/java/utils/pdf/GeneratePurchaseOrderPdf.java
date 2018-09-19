package com.bettkipchumba.java.utils.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.pdf.PdfWriter;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

public class GeneratePurchaseOrderPdf {
   /* public static void main(String []args){
        new GeneratePurchaseOrderPdf();
    }*/

    public GeneratePurchaseOrderPdf(Date start, Date to) {
        try {
            Document document = new Document();
            document.setPageSize(PageSize.A3);
            PdfWriter.getInstance(document, new FileOutputStream(start+"to"+to+"--purchaseOrder.pdf"));
            //PdfWriter.getInstance(document, new FileOutputStream(new File(System.getProperty("user.home/Documents"),start+"/"+to+"--purchaseOrder.pdf")));

            document.open();

            /*Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
            Chunk chunk = new Chunk("Purchase Order", font);
            document.add(chunk);*/
            document.add(TableBuilder.createTable(start,to));

            System.out.println( "generating pdf ......." );
            System.out.println( "finishing ......." );
            System.out.println( "PDF Created!" );
            document.close();

            JOptionPane.showMessageDialog(null, start+"to"+to+"--purchaseOrder.pdf" +
                            "  Generated successfull",
                    "Belisco Softwares Message Service", JOptionPane.INFORMATION_MESSAGE);
            if (Desktop.isDesktopSupported()) {
                try {
                    File myFile = new File(start+"to"+to+"--purchaseOrder.pdf");
                    Desktop.getDesktop().open(myFile);
                } catch (IOException ex) {
                    // no application registered for PDFs
                }
            }

        } catch (FileNotFoundException exc){
            System.out.print(exc.getMessage());
        } catch (DocumentException e) {
            e.printStackTrace();
        }
    }
}
