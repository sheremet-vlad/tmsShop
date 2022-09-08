package com.teachmeskills.service;

import com.teachmeskills.entity.employee.Manager;
import com.teachmeskills.entity.employee.Security;

public class MainService
{
    public static void main(String[] args) {
        EmployeeService employeeService = new EmployeeService();

        employeeService.takeEmployee(new Security("OLeg", " Ivanov",
                "Security", 500L, (byte) 5, "Пистолет"));

        employeeService.takeEmployee(new Manager("Kirill", " Smoler",
                "Manager", 1000L, (byte) 10, (byte) 5));

        employeeService.printEmployeeList();

        employeeService.fireEmployee(1);
    }
}
