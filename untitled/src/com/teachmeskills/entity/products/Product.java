package com.teachmeskills.entity.products;

public abstract class Product implements Comparable<Product>{

    private int productId;
    private String name;
    private double price;
    private  int quantity;
    private String typeProduct;

    @Override
    public int compareTo(Product o)
    {
        return Double.compare(this.price, o.price);
    }

    public Product(int productId, String name, double price, int quantity, String typeProduct) {
        this.productId = productId;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.typeProduct = typeProduct;
    }

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
}
