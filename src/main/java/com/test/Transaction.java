package com.test;

public class Transaction {
    private String asinCode;
    private int categoryCode;
    private int vatRate;
    private String status;

    public int getVatRate() {
        return vatRate;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getAsinCode() {
        return asinCode;
    }

    public void setAsinCode(String asinCode) {
        this.asinCode = asinCode;
    }

    public int getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(int categoryCode) {
        this.categoryCode = categoryCode;
    }

}