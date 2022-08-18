package com.teachmeskills.service.CustomerService;

import com.teachmeskills.entity.customers.Customer;
import com.teachmeskills.entity.customers.PositiveCustomer;
import com.teachmeskills.entity.products.Product;

public class CustomerService
{
    public boolean isCome(Customer customer)
    {
        if (customer.getCustomerMoney() < 500)
        {
            return false;
        }
        else
        {
            return true;
        }
    }

    public String isGone(Customer customer)
    {
        return null;
    }

    public void payForProduct(Customer customer)
    {

    }

    public double checkBalance(Customer customer)
    {
        return customer.getCustomerMoney();
    }

    public String[] addToBucket(Customer customer, Product product)
    {
        String[] currentArray = customer.getCustomerBucket();
        String[] updatedArray = new String[currentArray.length+1];
        System.arraycopy(currentArray, 0, updatedArray, 0, updatedArray.length);
        updatedArray[updatedArray.length-1] = product.getName();
        return updatedArray;
    }
}
