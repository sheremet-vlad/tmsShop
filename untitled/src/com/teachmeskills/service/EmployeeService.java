package com.teachmeskills.service;

import com.teachmeskills.entity.employee.Employee;
import com.teachmeskills.entity.shop.Shop;
import java.util.*;
import java.util.stream.Collectors;

public class EmployeeService {
    private final static int FINE_PERCENT = 20;
    private final static int AWARD_PERCENT = 20;

    public void takeEmployee(Shop shop, Employee newEmployee) {
        shop.getEmployees().put(shop.getNumberPactWithEmployee(), newEmployee);
        shop.setNumberPactWithEmployee(shop.getNumberPactWithEmployee() + 1);
    }

    public void fireEmployee(Shop shop) {
        if(shop.getEmployees().size() == 0) {
            System.out.println("List of employees is null");
            return;
        }

        System.out.println("Enter the contract number of the employee to be fire");

        Scanner scanner= new Scanner(System.in);

        while (true) {
            int numberEmployee = scanner.nextInt();

            if (numberEmployee > 0 && numberEmployee < shop.getEmployees().size() + 1) {
                shop.getEmployees().remove(numberEmployee);
                break;
            } else {
                System.out.println("Enter correct contract number");
            }
        }
    }

    public void giveSalary(Shop shop) throws NullPointerException {
        if(shop.getEmployees().size() == 0) {
            System.out.println("List of employees is null");
            return;
        }

        System.out.println("Enter the employee's contract number for give salary");

        Scanner scanner = new Scanner(System.in);

        int numberEmployee;

        while (true) {
            numberEmployee = scanner.nextInt();

            if (shop.getEmployees().containsKey(numberEmployee)) {
                shop.setShopBalance(shop.getShopBalance() - shop.getEmployees().get(numberEmployee).getEmployeeSalary());
                break;
            } else {
                System.out.println("Enter correct contract number");
            }
        }

        System.out.println("Employee " + shop.getEmployees().get(numberEmployee) + "got a salary of " +
                shop.getEmployees().get(numberEmployee).getEmployeeSalary());
    }

    public void giveAward(Shop shop) {
        if(shop.getEmployees().size() == 0) {
            System.out.println("List of employees is null");
            return;
        }

        System.out.println("Enter the employee's contract number for give award");

        Scanner scanner = new Scanner(System.in);

        int numberEmployee;

        while (true) {
            numberEmployee = scanner.nextInt();

            if (shop.getEmployees().containsKey(numberEmployee)) {
                shop.setShopBalance(shop.getShopBalance() - shop.getEmployees().get(numberEmployee).getEmployeeSalary() / 100 * AWARD_PERCENT);
                break;
            } else {
                System.out.println("Enter correct contract number");
            }
        }

        System.out.println("Employee " + shop.getEmployees().get(numberEmployee) + "got a award of " +
                shop.getEmployees().get(numberEmployee).getEmployeeSalary() / 100 * AWARD_PERCENT);
    }

    public void giveFine(Shop shop) {
        if(shop.getEmployees().size() == 0) {
            System.out.println("List of employees is null");
            return;
        }

        System.out.println("Enter the employee's contract number for give fine");

        Scanner scanner = new Scanner(System.in);

        int numberEmployee;

        while (true) {
            numberEmployee = scanner.nextInt();

            if (shop.getEmployees().containsKey(numberEmployee)) {
                shop.setShopBalance(shop.getShopBalance() + shop.getEmployees().get(numberEmployee).getEmployeeSalary() / 100 * FINE_PERCENT);
                break;
            } else {
                System.out.println("Enter correct contract number");
            }
        }
    }

    public int getSecurityAverageSalary(Shop shop) throws NoSuchElementException{
        double averageSecuritySalary;

        try {
            averageSecuritySalary = shop.getEmployees().values().stream().
                    filter(employee -> Objects.equals(employee.getEmployeePosition(), "Security")).
                    mapToDouble(Employee::getEmployeeSalary).average().getAsDouble();
        } catch (NoSuchElementException e) {
            System.out.println("There are no security in our team");

            return 0;
        }

        return (int)averageSecuritySalary;
    }

    public void sortingEmployeeByExperience(Shop shop) {
        shop.setEmployees(shop.getEmployees().entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Employee::compareTo))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new)));
    }

    public void printEmployeeInfo(Shop shop) {
        shop.getEmployees().entrySet().forEach(employee -> System.out.println(employee.getValue().getEmployeeName() +
                employee.getValue().getEmployeeSurname() + " " + employee.getValue().getEmployeeSalary()));
    }

    public void printEmployeeMap(Shop shop) {
        System.out.println("List of employee:");

        for (Integer key: shop.getEmployees().keySet()){
            System.out.println(key+ " = " + shop.getEmployees().get(key));
        }
    }
}