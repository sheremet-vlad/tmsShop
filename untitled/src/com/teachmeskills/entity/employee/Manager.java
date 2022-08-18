package com.teachmeskills.entity.employee;

public class Manager extends Employee {
    private byte amountSubordinates;

    public Manager(String employeeName, String employeeSurname, String employeePosition, long salary, byte employeeExperience, byte amountSubordinates) {
        super(employeeName, employeeSurname, employeePosition, salary, employeeExperience);
        this.amountSubordinates = amountSubordinates;
    }

    public Manager(byte amountSubordinates) {
        this.amountSubordinates = amountSubordinates;
    }

    public byte getAmountSubordinates() {
        return amountSubordinates;
    }

    public void setAmountSubordinates(byte amountSubordinates) {
        this.amountSubordinates = amountSubordinates;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName ='" + getEmployeeName() + '\'' +
                ", employeeSurname = '" + getEmployeeSurname() + '\'' +
                ", employeePosition = '" + getEmployeePosition() + '\'' +
                ", salary = " + getEmployeeExperience() +
                ", employeeExperience = " + getEmployeeExperience() + ", " +
                "amountSubordinates = " + amountSubordinates + '}';
    }
}
