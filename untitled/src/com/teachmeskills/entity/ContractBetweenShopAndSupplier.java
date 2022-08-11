package com.teachmeskills.entity;

public class ContractBetweenShopAndSupplier {
    private String nameSupplier;
    private String numberContract;
    private String addressSupplier;
    private int supplierUnp;
    private String bankAccount;
    private String name;
    private String address;
    private int shopUnp;

    public ContractBetweenShopAndSupplier(String nameSupplier, String numberContract, String addressSupplier,
                                          int supplierUnp, String bankAccount, String name, String address,
                                          int shopUnp) {
        this.nameSupplier = nameSupplier;
        this.numberContract = numberContract;
        this.addressSupplier = addressSupplier;
        this.supplierUnp = supplierUnp;
        this.bankAccount = bankAccount;
        this.name = name;
        this.address = address;
        this.shopUnp = shopUnp;
    }

    public String getNameSupplier() {
        return nameSupplier;
    }

    public void setNameSupplier(String nameSupplier) {
        this.nameSupplier = nameSupplier;
    }

    public String getNumberContract() {
        return numberContract;
    }

    public void setNumberContract(String numberContract) {
        this.numberContract = numberContract;
    }

    public String getAddressSupplier() {
        return addressSupplier;
    }

    public void setAddressSupplier(String addressSupplier) {
        this.addressSupplier = addressSupplier;
    }

    public int getSupplierUnp() {
        return supplierUnp;
    }

    public void setSupplierUnp(int supplierUnp) {
        this.supplierUnp = supplierUnp;
    }

    public String getBankAccount() {
        return bankAccount;
    }

    public void setBankAccount(String bankAccount) {
        this.bankAccount = bankAccount;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getShopUnp() {
        return shopUnp;
    }

    public void setShopUnp(int shopUnp) {
        this.shopUnp = shopUnp;
    }

    @Override
    public String toString() {
        return "ContractBetweenShopAndSupplier{" +
                "nameSupplier='" + nameSupplier + '\'' +
                ", numberContract='" + numberContract + '\'' +
                ", addressSupplier='" + addressSupplier + '\'' +
                ", supplierUnp=" + supplierUnp +
                ", bankAccount='" + bankAccount + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", shopUnp=" + shopUnp +
                '}';
    }
}
