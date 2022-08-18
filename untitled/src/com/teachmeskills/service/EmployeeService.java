package com.teachmeskills.service;

import com.teachmeskills.entity.employee.Employee;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeService {
    Map<Integer, Employee> employeeList = new HashMap<>();
    int numberPactWithEmployee = 1;

    public void takeEmployee(Employee employee) {
        employeeList.put(numberPactWithEmployee, employee);
        numberPactWithEmployee++;
    }

    public void fireEmployee(Integer key) {
        System.out.println("Список сотрудников:");

        printEmployeeList();

        System.out.println("Выберите номер сотрудника, которого уволняем");

        Scanner scanner= new Scanner(System.in);

        boolean flag = false;

        while (!flag) {
            int numberEmployee = scanner.nextInt();
            int idEmployee = numberEmployee;

            if (numberEmployee > 0 && numberEmployee < employeeList.size() + 1) {
                flag = true;
                employeeList.remove(idEmployee);
                break;
            } else {
                System.out.println("Введите корректное значение");
            }
        }

        numberPactWithEmployee--;
    }

    public void printEmployeeList() {
        for (Integer key: employeeList.keySet()){
            System.out.println(key+ " = " + employeeList.get(key));
        }
    }
}
