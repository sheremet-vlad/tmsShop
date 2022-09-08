package com.teachmeskills.service.customer;

import com.teachmeskills.entity.customer.Customer;
import com.teachmeskills.entity.products.Product;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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

    public Double countSum(List<Customer> customers)
    {
        return customers.stream().mapToDouble(customer -> customer.getCustomerMoney())
                .sum();
    }

    public String getMaxHistory(List<Customer> customers)
    {
//        return customers.stream().map(customer -> customer.getOrdersHistory().length).
//                max(Comparator.comparingInt())
//                .get();
        return null;
    }

    public List<String> getFirstName(List<Customer> customers)
    {
        return customers.stream().map(customer -> customer.getCustomerFirstName()).collect(Collectors.toList());
    }

// cравнить стринги для истории вывести ммакисмальную
// нам приходит список кастомеров, пройтись по листу и вывести имя каждого
// вывести сумму всех их денег
}
