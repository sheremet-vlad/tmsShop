package com.teachmeskills.interfaces.productInterface;

import com.teachmeskills.entity.products.Product;

public interface Searchable <T> {
    Product searchProductByName(T object, Product product);
}
