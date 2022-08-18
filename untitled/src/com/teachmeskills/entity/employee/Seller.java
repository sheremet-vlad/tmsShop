package com.teachmeskills.entity.employee;

public class Seller extends Employee {
    private byte numberСashbox;
    private long dayRevenue;

    public Seller(String employeeName, String employeeSurname, String employeePosition, long salary, byte employeeExperience, byte numberСashbox, long dayRevenue) {
        super(employeeName, employeeSurname, employeePosition, salary, employeeExperience);
        this.numberСashbox = numberСashbox;
        this.dayRevenue = dayRevenue;
    }

    public Seller(byte numberСashbox, long dayRevenue) {
        this.numberСashbox = numberСashbox;
        this.dayRevenue = dayRevenue;
    }

    public byte getNumberСashbox() {
        return numberСashbox;
    }

    public void setNumberСashbox(byte numberСashbox) {
        this.numberСashbox = numberСashbox;
    }

    public long getDayRevenue() {
        return dayRevenue;
    }

    public void setDayRevenue(long dayRevenue) {
        this.dayRevenue = dayRevenue;
    }
}
