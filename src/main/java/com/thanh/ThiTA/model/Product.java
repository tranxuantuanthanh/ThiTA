package com.thanh.ThiTA.model;

public class Product {
    private int productId;
    private String productName;
    private int supplierId;
    private int categoryId;
    private String quantityPerUnit;
    private double unitPrice;
    private int unitInStock;
    private int unitOnOrder;
    private int reorderLevel;
    private byte discontinued;
    public Product() {
    }
    public int getProductId() {
        return productId;
    }
    public void setProductId(int productId) {
        this.productId = productId;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getSupplierId() {
        return supplierId;
    }
    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
    }
    public int getCategoryId() {
        return categoryId;
    }
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }
    public String getQuantityPerUnit() {
        return quantityPerUnit;
    }
    public void setQuantityPerUnit(String quantityPerUnit) {
        this.quantityPerUnit = quantityPerUnit;
    }
    public double getUnitPrice() {
        return unitPrice;
    }
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
    public int getUnitInStock() {
        return unitInStock;
    }
    public void setUnitInStock(int unitInStock) {
        this.unitInStock = unitInStock;
    }
    public int getUnitOnOrder() {
        return unitOnOrder;
    }
    public void setUnitOnOrder(int unitOnOrder) {
        this.unitOnOrder = unitOnOrder;
    }
    public int getReorderLevel() {
        return reorderLevel;
    }
    public void setReorderLevel(int reorderLevel) {
        this.reorderLevel = reorderLevel;
    }
    public byte getDiscontinued() {
        return discontinued;
    }
    public void setDiscontinued(byte discontinued) {
        this.discontinued = discontinued;
    }
}
