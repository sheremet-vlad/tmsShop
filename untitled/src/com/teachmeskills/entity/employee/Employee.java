package com.teachmeskills.entity.employee;

public class Employee implements Comparable<Employee> {
    private String employeeName;
    private String employeeSurname;
    private String employeePosition;
    private long employeeSalary;
    private byte employeeExperience;

    public Employee(String employeeName, String employeeSurname, String employeePosition, long employeeSalary, byte employeeExperience) {
        this.employeeName = employeeName;
        this.employeeSurname = employeeSurname;
        this.employeePosition = employeePosition;
        this.employeeSalary = employeeSalary;
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

    public long getEmployeeSalary() {
        return employeeSalary;
    }

    public void setEmployeeSalary(long employeeSalary) {
        this.employeeSalary = employeeSalary;
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
                ", salary='" + employeeSalary + '\'' +
                ", employeeExperience=" + employeeExperience +
                '}';
    }

    @Override
    public int compareTo(Employee o) {
        return Integer.compare(this.getEmployeeExperience(), (int)o.getEmployeeExperience());
    }
}
