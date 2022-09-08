package com.teachmeskills.entity.products;

public class Milk extends Product {
    private double weight;

    public Milk(int productId, String name, double price, int quantity, String typeProduct, double weight) {
        super(productId, name, price, quantity, typeProduct);
        this.weight = weight;
    }

    public Milk() {
        super();
    }

    @Override
    public Product cloneProduct() {
        return new Milk(
                super.getProductId(),
                super.getName(),
                super.getPrice(),
                super.getQuantity(),
                super.getTypeProduct(),
                this.weight
        );
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }
}
