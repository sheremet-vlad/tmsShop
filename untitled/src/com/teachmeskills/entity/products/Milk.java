package com.teachmeskills.entity.products;

public class Milk extends Product {
    private double weight;

    public Milk(int productId, String name, double price, int quantity, String typeProduct, double weight) {
        super(productId, name, price, quantity, typeProduct);
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        return "Milk{" + "weight=" + weight + '}';
    }
}
