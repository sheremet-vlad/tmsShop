package com.teachmeskills.entity.employee;

public class Employee
{
    private String employeeName;
    private String employeeSurname;
    private String employeePosition;
    private String salary;
    private byte employeeExperience;

    public Employee(String employeeName, String employeeSurname, String employeePosition, String salary, byte employeeExperience) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeePosition = employeePosition;
        this.salary = salary;
        this.employeeExperience = employeeExperience;
    }

    public Employee() {
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeSurname() {
        return employeeSurname;
    }

    public void setEmployeeSurname(String employeeSurname) {
        this.employeeSurname = employeeSurname;
    }

    public String getEmployeePosition() {
        return employeePosition;
    }

    public void setEmployeePosition(String employeePosition) {
        this.employeePosition = employeePosition;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public byte getEmployeeExperience() {
        return employeeExperience;
    }

    public void setEmployeeExperience(byte employeeExperience) {
        this.employeeExperience = employeeExperience;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeSurname='" + employeeSurname + '\'' +
                ", employeePosition='" + employeePosition + '\'' +
                ", salary='" + salary + '\'' +
                ", employeeExperience=" + employeeExperience +
                '}';
    }
}
