package com.teachmeskills.entity.products;

public class Water extends Product {
    double volume;

    public Water(int productId, String name, double price, int quantity, String typeProduct, double volume) {
        super(productId, name, price, quantity, typeProduct);
        this.volume = volume;
    }

    public Water() {
        super();
    }

    @Override
    public Product cloneProduct() {
        return new Water(
                super.getProductId(),
                super.getName(),
                super.getPrice(),
                super.getQuantity(),
                super.getTypeProduct(),
                this.volume
        );
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
