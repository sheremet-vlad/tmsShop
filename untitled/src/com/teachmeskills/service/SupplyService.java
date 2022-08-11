package com.teachmeskills.service;
import com.teachmeskills.entity.Supplier;
import com.teachmeskills.entity.shop.Shop;

public class SupplyService {
    public void createContract(Shop shop, Supplier supplier){
        System.out.println("Contract created between shop" + shop.getName() + " and supplier" + supplier.getNameSupplier());
    }
}
