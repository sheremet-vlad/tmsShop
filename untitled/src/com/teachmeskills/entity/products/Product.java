package com.teachmeskills.entity.products;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.CLASS,
        property = "@class"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = Milk.class, name = "Milk"),
        @JsonSubTypes.Type(value = Chocolate.class, name = "Chocolate"),
        @JsonSubTypes.Type(value = Water.class, name = "Water")
})
public abstract class Product {
    private int productId;
    private String name;
    private double price;
    private  int quantity;
    private String typeProduct;

    protected Product(int productId, String name, double price, int quantity, String typeProduct) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.typeProduct = typeProduct;
    }

    protected Product() {}

    public String getTypeProduct() {
        return typeProduct;
    }

    public void setTypeProduct(String typeProduct) {
        this.typeProduct = typeProduct;
    }

    public int getProductId()
    {
        return productId;
    }

    public void setProductId(int productId)
    {
        this.productId = productId;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", typeProduct='" + typeProduct + '\'' +
                '}';
    }

    public abstract Product cloneProduct();
}
