package com.teachmeskills.utils.productUtils;

import com.teachmeskills.entity.products.Product;

public final class checkOperatorKeyUtil {
    private checkOperatorKeyUtil() {

    }

    public static void printMessageComparison(int comparisonCode,
                                              final Product firstProduct,
                                              final Product secondProduct) {
        switch (comparisonCode) {
            case -1 ->
                System.out.println(firstProduct.getName() + " cheaper than " + secondProduct.getName());
            case 0 ->
                System.out.println("Goods are equal in price");
            case 1 ->
                System.out.println(firstProduct.getName() + " more expensive than " + secondProduct.getName());
        }
    }
}
