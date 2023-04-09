package com.thanh.ThiTA.model;

public class Shipper {
    private int shipperId;
    private String companyName;
    private String phone;
    public int getShipperId() {
        return shipperId;
    }
    public Shipper() {
    }
    public void setShipperId(int shipperId) {
        this.shipperId = shipperId;
    }
    public String getCompanyName() {
        return companyName;
    }
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }
    public String getPhone() {
        return phone;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
}
