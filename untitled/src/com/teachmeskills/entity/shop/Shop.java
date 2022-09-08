package com.teachmeskills.entity.shop;

import com.teachmeskills.entity.CustomerEntity.Customer;
import com.teachmeskills.entity.Supplier;
//import com.teachmeskills.entity.customers.Customer;
import com.teachmeskills.entity.employee.Employee;
import com.teachmeskills.entity.products.Product;
//import com.teachmeskills.entity.supplier.Supplier;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

//магазины - открыть, закрыть, ремонт, переучет, уборка, прочитать книгу пожеланий
public class Shop
{
    private String name;
    private String address;
    private ShopSize shopSize;
    private Map<Integer, Employee> employees;
    private List<Product> products;
    private Supplier[] suppliers;
    private Customer[] customers;
    private Statuses[] statuses;
    private WishBook wishBook;
    private long shopBalance;
    private int numberPactWithEmployee;

    public Shop(String name, String address, ShopSize shopSize, Map<Integer, Employee> employees,
                List<Product> products, Supplier[] suppliers, Customer[] customers, Statuses[] statuses,
                WishBook wishBook, long shopBalance) {
        this.name = name;
        this.address = address;
        this.shopSize = shopSize;
        this.employees = employees;
        this.products = products;
        this.suppliers = suppliers;
        this.customers = customers;
        this.statuses = statuses;
        this.wishBook = wishBook;
        this.shopBalance = shopBalance;
        this.numberPactWithEmployee = 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public ShopSize getShopSize() {
        return shopSize;
    }

    public void setShopSize(ShopSize shopSize) {
        this.shopSize = shopSize;
    }

    public Map<Integer, Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Map<Integer, Employee> employees) {
        this.employees = employees;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Supplier[] getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(Supplier[] suppliers) {
        this.suppliers = suppliers;
    }

    public Customer[] getCustomers() {
        return customers;
    }

    public void setCustomers(Customer[] customers) {
        this.customers = customers;
    }

    public Statuses[] getStatuses() {
        return statuses;
    }

    public void setStatuses(Statuses[] statuses) {
        this.statuses = statuses;
    }

    public WishBook getWishBook() {
        return wishBook;
    }

    public void setWishBook(WishBook wishBook) {
        this.wishBook = wishBook;
    }

    public long getShopBalance() {
        return shopBalance;
    }

    public void setShopBalance(long shopBalance) {
        this.shopBalance = shopBalance;
    }

    public int getNumberPactWithEmployee() {
        return numberPactWithEmployee;
    }

    public void setNumberPactWithEmployee(int numberPactWithEmployee) {
        this.numberPactWithEmployee = numberPactWithEmployee;
    }
}
