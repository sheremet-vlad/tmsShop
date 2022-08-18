package com.teachmeskills.entity.supplier;

public class ContractBetweenSupplierAndShop {
    private String nameSupplier;
    private String nameShop;
    private int unp;
    private String addressShop;
    private String supplierAddress;

    public ContractBetweenSupplierAndShop(String nameSupplier, String nameShop, int unp, String addressShop,
                                          String supplierAddress) {
        this.nameSupplier = nameSupplier;
        this.nameShop = nameShop;
        this.unp = unp;
        this.addressShop = addressShop;
        this.supplierAddress = supplierAddress;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getNameShop() {
        return nameShop;
    }

    public void setNameShop(String nameShop) {
        this.nameShop = nameShop;
    }

    public int getUnp() {
        return unp;
    }

    public void setUnp(int unp) {
        this.unp = unp;
    }

    public String getAddressShop() {
        return addressShop;
    }

    public void setAddressShop(String addressShop) {
        this.addressShop = addressShop;
    }

    public String getSupplierAddress() {
        return supplierAddress;
    }

    public void setSupplierAddress(String supplierAddress) {
        this.supplierAddress = supplierAddress;
    }

    @Override
    public String toString() {
        return "ContractBetweenSupplierAndShop{" +
                "nameSupplier='" + nameSupplier + '\'' +
                ", nameShop='" + nameShop + '\'' +
                ", unp=" + unp +
                ", addressShop='" + addressShop + '\'' +
                ", supplierAddress='" + supplierAddress + '\'' +
                '}';
    }
}
