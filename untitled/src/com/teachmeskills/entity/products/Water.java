package com.teachmeskills.entity.products;

public class Water extends Product
{
    double volume;

    public Water(int productId, String name, double price, int quantity, String typeProduct)
    {
        super(productId, name, price, quantity, typeProduct);
    }

    public double getVolume()
    {
        return volume;
    }

    public void setVolume(double volume)
    {
        this.volume = volume;
    }
}
