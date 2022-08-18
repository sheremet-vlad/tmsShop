package com.teachmeskills.entity.supplier;

public abstract class Supplier
{
 private String nameSupplier;
 private String numberContract;
 private int phoneNumber;
 private String addressSupplier;
 private String emailAddress;
 private String bankAccount;
 private int supplierUnp;

 public Supplier(String nameSupplier, String numberContract, int phoneNumber, String addressSupplier,
                 String emailAddress, String bankAccount, int unp) {
  this.nameSupplier = nameSupplier;
  this.numberContract = numberContract;
  this.phoneNumber = phoneNumber;
  this.addressSupplier = addressSupplier;
  this.emailAddress = emailAddress;
  this.bankAccount = bankAccount;
  this.supplierUnp = unp;
 }

 public Supplier() {
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

 public int getPhoneNumber() {
  return phoneNumber;
 }

 public void setPhoneNumber(int phoneNumber) {
  this.phoneNumber = phoneNumber;
 }

 public String getAddressSupplier() {
  return addressSupplier;
 }

 public void setAddressSupplier(String addressSupplier) {
  this.addressSupplier = addressSupplier;
 }

 public String getEmailAddress() {
  return emailAddress;
 }

 public void setEmailAddress(String emailAddress) {
  this.emailAddress = emailAddress;
 }

 public String getBankAccount() {
  return bankAccount;
 }

 public void setBankAccount(String bankAccount) {
  this.bankAccount = bankAccount;
 }

 public int getSupplierUnp() {
  return supplierUnp;
 }

 public void setSupplierUnp(int supplierUnp) {
  this.supplierUnp = supplierUnp;
 }

 @Override
 public String toString() {
  return "Supplier{" +
          "nameSupplier='" + nameSupplier + '\'' +
          ", numberContract='" + numberContract + '\'' +
          ", phoneNumber=" + phoneNumber +
          ", addressSupplier='" + addressSupplier + '\'' +
          ", emailAddress='" + emailAddress + '\'' +
          ", bankAccount='" + bankAccount + '\'' +
          ", unp=" + supplierUnp +
          '}';
 }
}
