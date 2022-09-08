package com.teachmeskills.interfaces.productInterface;

import com.teachmeskills.entity.products.Product;

public interface Removable<T> {
    void  removeProduct(T object, Product product);
}