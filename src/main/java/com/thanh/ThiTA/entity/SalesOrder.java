package com.thanh.ThiTA.entity;

import java.util.Date;

public class SalesOrder {
    private int orderId;
    private int custId;
    private int employeeId;
    private Date orderDate;
    private Date requireDate;
    private Date shippedDate;
    private int ShipperId;
    private double freight;
    private String shipName;
    private String shipAddress;
    private String shipCity;
    private String shipRegion;
    private String shipPostalCode;
    private String shipCountry;
    public SalesOrder() {
    }
    public int getOrderId() {
        return orderId;
    }
    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }
    public int getCustId() {
        return custId;
    }
    public void setCustId(int custId) {
        this.custId = custId;
    }
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public Date getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
    public Date getRequireDate() {
        return requireDate;
    }
    public void setRequireDate(Date requireDate) {
        this.requireDate = requireDate;
    }
    public Date getShippedDate() {
        return shippedDate;
    }
    public void setShippedDate(Date shippedDate) {
        this.shippedDate = shippedDate;
    }
    public int getShipperId() {
        return ShipperId;
    }
    public void setShipperId(int shipperId) {
        ShipperId = shipperId;
    }
    public double getFreight() {
        return freight;
    }
    public void setFreight(double freight) {
        this.freight = freight;
    }
    public String getShipName() {
        return shipName;
    }
    public void setShipName(String shipName) {
        this.shipName = shipName;
    }
    public String getShipAddress() {
        return shipAddress;
    }
    public void setShipAddress(String shipAddress) {
        this.shipAddress = shipAddress;
    }
    public String getShipCity() {
        return shipCity;
    }
    public void setShipCity(String shipCity) {
        this.shipCity = shipCity;
    }
    public String getShipRegion() {
        return shipRegion;
    }
    public void setShipRegion(String shipRegion) {
        this.shipRegion = shipRegion;
    }
    public String getShipPostalCode() {
        return shipPostalCode;
    }
    public void setShipPostalCode(String shipPostalCode) {
        this.shipPostalCode = shipPostalCode;
    }
    public String getShipCountry() {
        return this.shipCountry;
    }
    public void setShipCountry(String shipCountry) {
        this.shipCountry = shipCountry;
    }
}
