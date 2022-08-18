package com.teachmeskills.entity.employee;

public class Security extends Employee {
    private String weapon;

    public Security(String employeeName, String employeeSurname, String employeePosition, long salary, byte employeeExperience, String weapon) {
        super(employeeName, employeeSurname, employeePosition, salary, employeeExperience);
        this.weapon = weapon;
    }

    public Security(String weapon) {
        this.weapon = weapon;
    }

    @Override
    public String toString() {
        return "Employee{" +
                        "employeeName = '" + getEmployeeName() + '\'' +
                        ", employeeSurname = '" + getEmployeeSurname() + '\'' +
                        ", employeePosition = '" + getEmployeePosition() + '\'' +
                        ", salary = " + getEmployeeExperience() +
                        ", employeeExperience = " + getEmployeeExperience() + ", " +
                         "weapon='" + weapon + '\'' + '}';
    }
}
