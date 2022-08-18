package com.teachmeskills.entity.shop;

import com.teachmeskills.entity.CustomerEntity.Customer;
import com.teachmeskills.entity.employee.Employee;
import com.teachmeskills.entity.products.Product;
import com.teachmeskills.entity.Supplier;

//магазины - открыть, закрыть, ремонт, переучет, уборка, прочитать книгу пожеланий
public class Shop
{
    private String name;
    private String address;
    private ShopSize shopSize;
    private Employee[] employees;
    private Product[] products;
    private Supplier[] suppliers;
    private Customer[] customers;

    private Statuses[] statuses;

    private WishBook wishBook;

    public Shop() {
    }

    public Shop(String name, String address, ShopSize shopSize, Employee[] employees, Product[] products,
                Supplier[] suppliers, Customer[] customers) {
        this.name = name;
        this.address = address;
        this.shopSize = shopSize;
        this.employees = employees;
        this.products = products;
        this.suppliers = suppliers;
        this.customers = customers;
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

    public Employee[] getEmployees() {
        return employees;
    }

    public void setEmployees(Employee[] employees) {
        this.employees = employees;
    }

    public Product[] getProducts() {
        return products;
    }

    public void setProducts(Product[] products) {
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
}
