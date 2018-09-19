package com.bettkipchumba.java.model;

import java.sql.Date;

public class PurchaseOrder {
    Date lpoDate;
    String purchaseDescription;
    String unitOfIssue;
    int quantity;
    double unitPrice;
    double totalPrice;
    String pl4;
    String requestBy;
    String vehicleNo;
    String department;
    String lpoNo;
    String authorisedBy;
    String procumentMethod;
    String supplier;
    String invoiceNo;
    String qteNO;

    public PurchaseOrder(Date lpoDate, String purchaseDescription, String unitOfIssue, int quantity,
                         double unitPrice, double totalPrice, String pl4, String requestBy,
                         String vehicleNo, String department, String lpoNo, String authorisedBy,
                         String procumentMethod, String supplier, String invoiceNo, String qteNO) {
        this.lpoDate = lpoDate;
        this.purchaseDescription = purchaseDescription;
        this.unitOfIssue = unitOfIssue;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.pl4 = pl4;
        this.requestBy = requestBy;
        this.vehicleNo = vehicleNo;
        this.department = department;
        this.lpoNo = lpoNo;
        this.authorisedBy = authorisedBy;
        this.procumentMethod = procumentMethod;
        this.supplier = supplier;
        this.invoiceNo = invoiceNo;
        this.qteNO = qteNO;
    }

    public PurchaseOrder() {
    }

    public Date getLpoDate() {
        return lpoDate;
    }

    public void setLpoDate(Date lpoDate) {
        this.lpoDate = lpoDate;
    }

    public String getPurchaseDescription() {
        return purchaseDescription;
    }

    public void setPurchaseDescription(String purchaseDescription) {
        this.purchaseDescription = purchaseDescription;
    }

    public String getUnitOfIssue() {
        return unitOfIssue;
    }

    public void setUnitOfIssue(String unitOfIssue) {
        this.unitOfIssue = unitOfIssue;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getPl4() {
        return pl4;
    }

    public void setPl4(String pl4) {
        this.pl4 = pl4;
    }

    public String getRequestBy() {
        return requestBy;
    }

    public void setRequestBy(String requestBy) {
        this.requestBy = requestBy;
    }

    public String getVehicleNo() {
        return vehicleNo;
    }

    public void setVehicleNo(String vehicleNo) {
        this.vehicleNo = vehicleNo;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLpoNo() {
        return lpoNo;
    }

    public void setLpoNo(String lpoNo) {
        this.lpoNo = lpoNo;
    }

    public String getAuthorisedBy() {
        return authorisedBy;
    }

    public void setAuthorisedBy(String authorisedBy) {
        this.authorisedBy = authorisedBy;
    }

    public String getProcumentMethod() {
        return procumentMethod;
    }

    public void setProcumentMethod(String procumentMethod) {
        this.procumentMethod = procumentMethod;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public String getQteNO() {
        return qteNO;
    }

    public void setQteNO(String qteNO) {
        this.qteNO = qteNO;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "lpoDate='" + lpoDate + '\'' +
                ", purchaseDescription='" + purchaseDescription + '\'' +
                ", unitOfIssue='" + unitOfIssue + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", pl4='" + pl4 + '\'' +
                ", requestBy='" + requestBy + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", department='" + department + '\'' +
                ", lpoNo='" + lpoNo + '\'' +
                ", authorisedBy='" + authorisedBy + '\'' +
                ", procumentMethod='" + procumentMethod + '\'' +
                ", supplier='" + supplier + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", qteNO='" + qteNO + '\'' +
                '}';
    }
}
