package com.teachmeskills.service.CustomerService;

import com.teachmeskills.entity.supplier.ContractBetweenSupplierAndShop;

public class SupplyService {

    public ContractBetweenSupplierAndShop createContract(String nameSupplier, String nameShop, int unp, String addressShop,
                               String supplierAddress)
    {
        ContractBetweenSupplierAndShop contract = new ContractBetweenSupplierAndShop(nameSupplier, nameShop,
                unp, addressShop, supplierAddress);
        System.out.println("Контракт между " + contract.getNameShop() + " и " + contract.getNameSupplier() +
                " был заключен");
        return contract;
    }

    public void terminateContract(ContractBetweenSupplierAndShop contract)
    {
        contract.setAddressShop(null);
        contract.setNameShop(null);
        contract.setNameSupplier(null);
        contract.setUnp(0);
        contract.setSupplierAddress(null);
        System.out.println("Контракт между " + contract.getNameShop() + " и " + contract.getNameSupplier() +
                " был расторгнут");
    }

//    public int calculateCosts
}

