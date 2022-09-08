package com.teachmeskills.service;

import com.teachmeskills.entity.CustomerEntity.Customer;
import com.teachmeskills.entity.Supplier;
import com.teachmeskills.entity.employee.*;
import com.teachmeskills.entity.products.Product;
import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.entity.shop.Statuses;
import com.teachmeskills.entity.shop.WishBook;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import static com.teachmeskills.entity.shop.ShopSize.Super;

public class MainService
{
    public static void main(String[] args) throws IOException {
        ArrayList<Product> productList = new ArrayList<>();
        EmployeeService employeeService = new EmployeeService();

        Supplier[] arraySupplier = new Supplier[5];

        Customer[] arrayCustomer = new Customer[5];

        Statuses[] arrayStatues = new Statuses[5];

        Map<Integer, Employee> employeeMap = new HashMap<>();

        Shop shop = new Shop("Candyshop", "Shmidta", Super, employeeMap, productList,
                arraySupplier, arrayCustomer, arrayStatues, new WishBook(), 10000);

        //Check method for take employee
        employeeService.takeEmployee(shop, new Manager("Kirill", " Smoler",
                "Manager", 1000L, (byte) 10, (byte) 5));
        employeeService.takeEmployee(shop, new Manager("Arseniy", "Mitrofanov",
                "Manager", 1000L, (byte) 5, (byte) 5));
        employeeService.takeEmployee(shop, new Security("OLeg", " Ivanov",
                "Security", 500L, (byte) 5, "Пистолет"));
        employeeService.takeEmployee(shop, new Security("Vitaliy", "Halai",
                "Security", 400L, (byte) 9, "Золотой мяч"));
        employeeService.takeEmployee(shop, new Security("Miron", "Tolkanitsa",
                "Security", 600L, (byte) 3, "Мощная шея"));
        employeeService.takeEmployee(shop, new Security("Roman", "Savitski",
                "Security", 600L, (byte) 7, "AK-47"));

        //Check method for fire employee
        employeeService.printEmployeeMap(shop);
        employeeService.fireEmployee(shop);

        //Check method for print employee list with Name/Surname/Salary
        //employeeService.printEmployeeInfo(shop);

        //Check method for print employee list
        //employeeService.printEmployeeMap(shop);

        //Check method for sorting employee list by employee experience
        //employeeService.sortingEmployeeByExperience(shop);
        //employeeService.printEmployeeMap(shop);

        //Check method for give a salary
        //employeeService.giveSalary(shop);
        //System.out.println(shop.getShopBalance());

        //Check method for give an award;
        //employeeService.giveAward(shop);
        //System.out.println(shop.getShopBalance());

        //Check method for give a fine
        employeeService.printEmployeeMap(shop);
        employeeService.giveFine(shop);
        System.out.println(shop.getShopBalance());

        //Check method for get average salary of the security
        System.out.println(employeeService.getSecurityAverageSalary(shop));

        /*employeeService.printEmployeeMap();

        employeeService.giveSalary(shop);

        employeeService.giveAward(shop);

        employeeService.giveFine(shop);*//*

        System.out.println(shop.getShopBalance());*/

        /*TemporaryEmployee temporaryEmployee = new TemporaryEmployee("Oleg", " Ivanov",
                "Security", 400L, (byte) 2, 4);

        *//*ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(new File("./Employee.json"), temporaryEmployee);
        System.out.println(objectMapper.readValue("./Employee.json", TemporaryEmployee.class));
        TemporaryEmployee tempory1 = objectMapper.readValue(new File("Employee.json"), TemporaryEmployee.class);
        System.out.println(tempory1);*/
    }
}
