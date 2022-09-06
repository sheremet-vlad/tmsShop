package com.teachmeskills.service;

import com.teachmeskills.entity.employee.Manager;
import com.teachmeskills.entity.employee.Security;
import com.teachmeskills.entity.employee.Seller;
import com.teachmeskills.entity.supplier.Supplier;
import com.teachmeskills.entity.supplier.SupplierChemical;
import com.teachmeskills.json.ObjectToJson;

import java.io.IOException;

public class MainService
{
    public static void main(String[] args) throws IOException {
        SupplierChemical supplier = new SupplierChemical();
        supplier.setAddressSupplier("Antoniuk street");
        supplier.setNameSupplier("Chemic");
        supplier.setBankAccount("8478234");
        supplier.setPhoneNumber(942763874);

        ObjectToJson objectToJson = new ObjectToJson();

        objectToJson.ConvertToJSON(supplier, "D://");
        Supplier newsup = objectToJson.ConvertFromJONtoObject(SupplierChemical.class, "D:\\TMS\\tmsShop\\book.json");
        newsup.toString();
    }
}
