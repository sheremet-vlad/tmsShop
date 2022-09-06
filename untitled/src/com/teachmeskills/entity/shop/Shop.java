package com.teachmeskills.entity.shop;

import com.teachmeskills.entity.customers.Customer;
import com.teachmeskills.entity.employee.Employee;
import com.teachmeskills.entity.products.Product;
import com.teachmeskills.entity.supplier.Supplier;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//магазины - открыть, закрыть, ремонт, переучет, уборка, прочитать книгу пожеланий
public class Shop
{
    private String name;
    private String address;
    private ShopSize shopSize;
    private List<Employee> employees = new ArrayList<>();
    private List<Product> products;
    private List<Supplier> suppliers = new ArrayList<>();
    private List<Customer> customers = new ArrayList<>();

    private List<Statuses> statuses;

    private WishBook wishBook;

    public Shop() {
    }

    public Shop(String name, String address, ShopSize shopSize, List<Employee> employees, List<Product> products,
                List<Supplier> suppliers, List<Customer> customers, List<Statuses> statuses, WishBook wishBook) {
        this.name = name;
        this.address = address;
        this.shopSize = shopSize;
        this.employees = employees;
        this.products = products;
        this.suppliers = suppliers;
        this.customers = customers;
        this.statuses = statuses;
        this.wishBook = wishBook;
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

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Supplier> getSuppliers() {
        return suppliers;
    }

    public void setSuppliers(List<Supplier> suppliers) {
        this.suppliers = suppliers;
    }

    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

    public List<Statuses> getStatuses() {
        return statuses;
    }

    public void setStatuses(List<Statuses> statuses) {
        this.statuses = statuses;
    }

    public WishBook getWishBook() {
        return wishBook;
    }

    public void setWishBook(WishBook wishBook) {
        this.wishBook = wishBook;
    }

    public String printClassForShopSortingTesting() {
        return "Shop{employees=" + employees.size() +
                ", customers=" + customers.size() +
                ", statuses=" + statuses +
                ", wishBook=" + wishBook.getWishBookNotes().size() +
                '}';
    }

    public String printClassToFindShopWithHighestSalary() {
        return "Shop{" + employees + "}";
    }

    @Override
    public String toString() {
        return "Shop{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", shopSize=" + shopSize +
                ", employees=" + employees +
                ", products=" + products +
                ", suppliers=" + suppliers +
                ", customers=" + customers +
                ", statuses=" + statuses +
                ", wishBook=" + wishBook +
                '}';
    }
}
