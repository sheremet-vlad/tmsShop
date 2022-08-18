package com.teachmeskills.interfaces;

public interface Searchable <T, Product>{
    Product searchProductByName(T object, Product product);
}
