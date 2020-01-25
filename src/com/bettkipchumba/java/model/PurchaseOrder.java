package com.bettkipchumba.java.model;

import java.sql.Date;

public class PurchaseOrder {
    String lpoNo;
    Date lpoDate;
    String ItemDescription;
    String unitOfIssue;
    int quantity;
    double unitPrice;
    double totalPrice;
    String pl4;
    String requestBy;
    String vehicleNo;
    String department;
    String authorisedBy;
    String procumentMethod;
    String procumentReference;
    String supplier;
    String schemeApplied;
    String schemeRegNo;
    String invoiceNo;
    Date invoiceDate;
    String invoiceAmount;
    String GRN_NO;
    String DeliveryNoteNo;
    String Status;

    public PurchaseOrder() {
    }

    public PurchaseOrder(String lpoNo, Date lpoDate, String itemDescription, String unitOfIssue, int quantity,
            double unitPrice,
            double totalPrice, String pl4, String requestBy, String vehicleNo, String department, String authorisedBy,
            String procumentMethod, String procumentReference, String supplier, String schemeApplied,
            String schemeRegNo, String invoiceNo, Date invoiceDate, String invoiceAmount, String GRN_NO,
            String deliveryNoteNo, String status) {
        this.lpoNo = lpoNo;
        this.lpoDate = lpoDate;
        ItemDescription = itemDescription;
        this.unitOfIssue = unitOfIssue;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.totalPrice = totalPrice;
        this.pl4 = pl4;
        this.requestBy = requestBy;
        this.vehicleNo = vehicleNo;
        this.department = department;
        this.authorisedBy = authorisedBy;
        this.procumentMethod = procumentMethod;
        this.procumentReference = procumentReference;
        this.supplier = supplier;
        this.schemeApplied = schemeApplied;
        this.schemeRegNo = schemeRegNo;
        this.invoiceNo = invoiceNo;
        this.invoiceDate = invoiceDate;
        this.invoiceAmount = invoiceAmount;
        this.GRN_NO = GRN_NO;
        DeliveryNoteNo = deliveryNoteNo;
        Status = status;
    }

    public String getLpoNo() {
        return lpoNo;
    }

    public void setLpoNo(String lpoNo) {
        this.lpoNo = lpoNo;
    }

    public Date getLpoDate() {
        return lpoDate;
    }

    public void setLpoDate(Date lpoDate) {
        this.lpoDate = lpoDate;
    }

    public String getItemDescription() {
        return ItemDescription;
    }

    public void setItemDescription(String itemDescription) {
        ItemDescription = itemDescription;
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

    public String getProcumentReference() {
        return procumentReference;
    }

    public void setProcumentReference(String procumentReference) {
        this.procumentReference = procumentReference;
    }

    public String getSupplier() {
        return supplier;
    }

    public void setSupplier(String supplier) {
        this.supplier = supplier;
    }

    public String getSchemeApplied() {
        return schemeApplied;
    }

    public void setSchemeApplied(String schemeApplied) {
        this.schemeApplied = schemeApplied;
    }

    public String getSchemeRegNo() {
        return schemeRegNo;
    }

    public void setSchemeRegNo(String schemeRegNo) {
        this.schemeRegNo = schemeRegNo;
    }

    public String getInvoiceNo() {
        return invoiceNo;
    }

    public void setInvoiceNo(String invoiceNo) {
        this.invoiceNo = invoiceNo;
    }

    public Date getInvoiceDate() {
        return invoiceDate;
    }

    public void setInvoiceDate(Date invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    public String getInvoiceAmount() {
        return invoiceAmount;
    }

    public void setInvoiceAmount(String invoiceAmount) {
        this.invoiceAmount = invoiceAmount;
    }

    public String getGRN_NO() {
        return GRN_NO;
    }

    public void setGRN_NO(String GRN_NO) {
        this.GRN_NO = GRN_NO;
    }

    public String getDeliveryNoteNo() {
        return DeliveryNoteNo;
    }

    public void setDeliveryNoteNo(String deliveryNoteNo) {
        DeliveryNoteNo = deliveryNoteNo;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    @Override
    public String toString() {
        return "PurchaseOrder{" +
                "lpoNo='" + lpoNo + '\'' +
                ", lpoDate=" + lpoDate +
                ", ItemDescription='" + ItemDescription + '\'' +
                ", unitOfIssue='" + unitOfIssue + '\'' +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", totalPrice=" + totalPrice +
                ", pl4='" + pl4 + '\'' +
                ", requestBy='" + requestBy + '\'' +
                ", vehicleNo='" + vehicleNo + '\'' +
                ", department='" + department + '\'' +
                ", authorisedBy='" + authorisedBy + '\'' +
                ", procumentMethod='" + procumentMethod + '\'' +
                ", procumentReference='" + procumentReference + '\'' +
                ", supplier='" + supplier + '\'' +
                ", schemeApplied='" + schemeApplied + '\'' +
                ", schemeRegNo='" + schemeRegNo + '\'' +
                ", invoiceNo='" + invoiceNo + '\'' +
                ", invoiceDate='" + invoiceDate + '\'' +
                ", invoiceAmount='" + invoiceAmount + '\'' +
                ", GRN_NO='" + GRN_NO + '\'' +
                ", DeliveryNoteNo='" + DeliveryNoteNo + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
