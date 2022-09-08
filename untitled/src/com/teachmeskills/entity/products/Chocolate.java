package com.teachmeskills.entity.products;

public class Chocolate extends Product {
    public Chocolate(int productId, String name, double price, int quantity, String typeProduct) {
        super(productId, name, price, quantity, typeProduct);
    }

    public Chocolate() {
        super();
    }

    @Override
    public Product cloneProduct() {
        return new Chocolate(
                super.getProductId(),
                super.getName(),
                super.getPrice(),
                super.getQuantity(),
                super.getTypeProduct()
        );
    }
}
