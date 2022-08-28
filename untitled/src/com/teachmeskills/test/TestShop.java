package com.teachmeskills.test;

import com.teachmeskills.entity.customers.Customer;
import com.teachmeskills.entity.employee.Employee;
import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.entity.shop.Statuses;
import com.teachmeskills.entity.shop.WishBook;
import com.teachmeskills.service.ShopService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Class to create test data to test Shop stream api Methods: getShopWithHighestSalary and sortShops.
 * To run any streamAPI method from ShopService, run appropriate method in this class with the "test" prefix.
 * Test methods from this class will crate test data and then call streamApi methods.
 * **/

public class TestShop {
    public static void main(String[] args) {
        TestShop testShop = new TestShop();
        //testShop.testShopSorting();
        testShop.testGetShopWithHighestSalary();
    }

    public void testShopSorting() {
        List<Shop> shops = new ArrayList<>();
        for (int i = 0; i < getRandomValueInRange(15, 30); i++) {
            shops.add(new Shop());
        }
        System.out.println("===== SHOPS =====");
        shops.forEach(TestShop::fillShopToTestShopSorting);
        System.out.println("===== SHOPS =====");

        System.out.println("===== RESULT =====");
        ShopService.sortShops(shops).forEach(x -> System.out.println(x.printClassForShopSortingTesting()));
        System.out.println("===== RESULT =====");
    }

    public void testGetShopWithHighestSalary() {
        List<Shop> shops = new ArrayList<>();
        for (int i = 0; i < getRandomValueInRange(2, 10); i++) {
            shops.add(new Shop());
        }
        System.out.println("===== SHOPS =====");
        shops.forEach(TestShop::fillShopWithTestDataToFindShopWithHighestSalary);
        System.out.println("===== SHOPS =====");

        System.out.println("===== RESULT =====");
        System.out.println(ShopService.getShopWithHighestSalary(shops)
                .printClassToFindShopWithHighestSalary());
        System.out.println("===== RESULT =====");
    }

    public static Shop fillShopWithTestDataToFindShopWithHighestSalary(Shop shop) {
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < getRandomValueInRange(5, 15); i++) {
            Employee employee = new Employee();
            employee.setSalary(getRandomValueInRange(10, 100));
            employees.add(employee);
        }
        shop.setEmployees(employees);
        System.out.println(shop.printClassToFindShopWithHighestSalary());
        return shop;
    }
    public static void fillShopToTestShopSorting(Shop shop) {
        List<Employee> employees = new ArrayList<>();
        List<Customer> customers = new ArrayList<>();
        WishBook wishBook = new WishBook();

        for (int i = 0; i < getRandomValueInRange(25, 50); i++) {
            Employee employee = new Employee();
            employees.add(employee);
        }

        for (int i = 0; i < getRandomValueInRange(13, 30); i++) {
            Customer customer = new Customer();
            customers.add(customer);
        }
        for (int i = 0; i < getRandomValueInRange(5, 100); i++) {
            wishBook.add("Test String " + i);
        }

        shop.setEmployees(employees);
        shop.setCustomers(customers);
        shop.setWishBook(wishBook);
        setRandomShopStatus(shop);

        System.out.println(shop.printClassForShopSortingTesting());
    }

    public static int getRandomValueInRange(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static void setRandomShopStatus(Shop shop) {
        List<Statuses> statuses = Arrays.asList(Statuses.values());
        int randomNumber = getRandomValueInRange(0, 4);
        shop.setStatuses(statuses.stream().filter(x -> x.equals(statuses.get(randomNumber))).toList());
    }
}
