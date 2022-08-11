package com.teachmeskills.entity.CustomerEntity;

public abstract class Customer
{
    private String customerFirstName;
    private String customerLastName;
    private String[] customerWishList;
    private String[] ordersHistory;

    private double customerMoney;

    public String getCustomerFirstName() {
        return customerFirstName;
    }

    public void setCustomerFirstName(String customerFirstName) {
        this.customerFirstName = customerFirstName;
    }

    public String getCustomerLastName() {
        return customerLastName;
    }

    public void setCustomerLastName(String customerLastName) {
        this.customerLastName = customerLastName;
    }

    public String[] getCustomerWishList() {
        return customerWishList;
    }

    public void setCustomerWishList(String[] customerWishList) {
        this.customerWishList = customerWishList;
    }

    public String[] getOrdersHistory() {
        return ordersHistory;
    }

    public void setOrdersHistory(String[] ordersHistory) {
        this.ordersHistory = ordersHistory;
    }

    public double getCustomerMoney() {
        return customerMoney;
    }

    public void setCustomerMoney(double customerMoney) {
        this.customerMoney = customerMoney;
    }

}
