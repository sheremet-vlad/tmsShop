package com.teachmeskills.entity.supplier;

import com.teachmeskills.entity.products.Product;
import com.teachmeskills.entity.shop.Shop;

import java.util.Arrays;
import java.util.stream.DoubleStream;

public class CostCalculator {
    public Double calculateCostsOfSupply (Product[] products) {
    Double  fixedCosts= 100.0;

    Double cots = Arrays.stream(products).sequential()
            .flatMapToDouble(product -> DoubleStream.of(product.getPrice()))
            .sum() + fixedCosts;

        return cots;
    }
}