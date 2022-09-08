package com.teachmeskills.entity.supplier;

import com.teachmeskills.entity.supplier.Supplier;

public class SupplierTechnology extends Supplier {
    public SupplierTechnology(String nameSupplier, String numberContract, int phoneNumber, String addressSupplier, String emailAddress, String bankAccount, int unp) {
        super(nameSupplier, numberContract, phoneNumber, addressSupplier, emailAddress, bankAccount, unp);
    }

    public SupplierTechnology() {
        super();
    }

    @Override
    public String getNameSupplier() {
        return super.getNameSupplier();
    }

    @Override
    public void setNameSupplier(String nameSupplier) {
        super.setNameSupplier(nameSupplier);
    }

    @Override
    public String getNumberContract() {
        return super.getNumberContract();
    }

    @Override
    public void setNumberContract(String numberContract) {
        super.setNumberContract(numberContract);
    }

    @Override
    public int getPhoneNumber() {
        return super.getPhoneNumber();
    }

    @Override
    public void setPhoneNumber(int phoneNumber) {
        super.setPhoneNumber(phoneNumber);
    }

    @Override
    public String getAddressSupplier() {
        return super.getAddressSupplier();
    }

    @Override
    public void setAddressSupplier(String addressSupplier) {
        super.setAddressSupplier(addressSupplier);
    }

    @Override
    public String getEmailAddress() {
        return super.getEmailAddress();
    }

    @Override
    public void setEmailAddress(String emailAddress) {
        super.setEmailAddress(emailAddress);
    }

    @Override
    public String getBankAccount() {
        return super.getBankAccount();
    }

    @Override
    public void setBankAccount(String bankAccount) {
        super.setBankAccount(bankAccount);
    }

    @Override
    public int getSupplierUnp() {
        return super.getSupplierUnp();
    }

    @Override
    public void setSupplierUnp(int supplierUnp) {
        super.setSupplierUnp(supplierUnp);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
