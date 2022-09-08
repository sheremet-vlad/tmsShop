package com.teachmeskills.entity.employee;

public class TemporaryEmployee extends Employee {
    private int amountWorkWeek;

    public TemporaryEmployee(String employeeName, String employeeSurname, String employeePosition,
                             long salary, byte employeeExperience, int amountWorkWeek) {
        super(employeeName, employeeSurname, employeePosition, salary, employeeExperience);
        this.amountWorkWeek = amountWorkWeek;
    }

    public TemporaryEmployee(int amountWorkWeek) {
        this.amountWorkWeek = amountWorkWeek;
    }

    public int getAmountWorkWeek() {
        return amountWorkWeek;
    }

    public void setAmountWorkWeek(int amountWorkWeek) {
        this.amountWorkWeek = amountWorkWeek;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + getEmployeeName() + '\'' +
                ", employeeSurname='" + getEmployeeSurname() + '\'' +
                ", employeePosition='" + getEmployeePosition() + '\'' +
                ", salary='" + getEmployeeSalary() + '\'' +
                ", employeeExperience=" + getEmployeeExperience() + ", amountWorkWeek='" + '\'' + amountWorkWeek +
                '}';
    }
}
