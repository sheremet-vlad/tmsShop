package com.teachmeskills.interfaces;

import java.util.List;

public interface Addable <T, Product>{
    void addProduct(T object, Product product, int counter);
}
