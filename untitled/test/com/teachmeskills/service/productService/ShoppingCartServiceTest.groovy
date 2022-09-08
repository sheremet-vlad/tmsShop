package com.teachmeskills.service.productService

import com.teachmeskills.entity.products.Chocolate
import com.teachmeskills.entity.products.Milk
import com.teachmeskills.entity.products.Product
import com.teachmeskills.entity.shop.Shop
import com.teachmeskills.entity.shop.ShoppingCart
import spock.lang.Specification

class ShoppingCartServiceTest extends Specification {
    def "AddProductToShoppingCart with bigger amount"() {
        given:
        ShopService shopService = new ShopService()

        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << milk
        shop.getProducts() >> productList

        ShoppingCartService shoppingCartService = new ShoppingCartService()

        ShoppingCart shoppingCart = new ShoppingCart()
        when: "Adding too many products in a cart"
        shoppingCartService.addProductToShoppingCart(shoppingCart, milk, 5, shop)
        then: "Exception should be thrown"
        def exception = thrown(RuntimeException)
        and: "With reasonable message"
        exception.message == "There are not enough products in the store"
        and: "List of products should be intact"
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(milk.name, 3)]
        and: "Shopping cart should be empty"
        shoppingCart.getProductList().isEmpty()
    }

    def "AddProductToShoppingCart"() {
        given:
        ShopService shopService = new ShopService()

        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)
        Product chocolate = new Chocolate(2, "Chocolate", 3.51, 10, "product")

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << milk << chocolate
        shop.getProducts() >> productList

        ShoppingCartService shoppingCartService = new ShoppingCartService()

        ShoppingCart shoppingCart = new ShoppingCart()
        when: "Adding products to shopping cart"
        shoppingCartService.addProductToShoppingCart(shoppingCart, milk, 2, shop)
        then: "Products should be added to shopping cart"
        shoppingCart.productList.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(milk.name, 2)]
        and: "Subtract from shop"
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(chocolate.name, 10), new Tuple(milk.name, 1)]
    }

    def "AddProductToShoppingCart if cart isn't empty"() {
        given:
        ShopService shopService = new ShopService()

        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)
        Product milkInCart = new Milk(1, "Milk", 2.68, 3, "product", 1000)
        Product chocolate = new Chocolate(2, "Chocolate", 3.51, 10, "product")

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << milk << chocolate
        shop.getProducts() >> productList

        ShoppingCartService shoppingCartService = new ShoppingCartService()

        ShoppingCart shoppingCart = new ShoppingCart()
        shoppingCart.productList << milkInCart
        when: "Adding products to shopping cart"
        shoppingCartService.addProductToShoppingCart(shoppingCart, milk, 2, shop)
        then: "Products should be added to shopping cart"
        shoppingCart.productList.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(milk.name, 3 + 2)]
        and: "Subtract from shop"
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(chocolate.name, 10), new Tuple(milk.name, 3 - 2)]
    }

    def "RemoveProduct with empty cart"() {
        given:
        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)

        ShopService shopService = new ShopService()

        Shop shop = Mock()

        ShoppingCartService shoppingCartService = new ShoppingCartService()

        ShoppingCart shoppingCart = new ShoppingCart()
        List<Product> productList = new ArrayList<>()
        shoppingCart.setProductList(productList)
        when: "Removing product from empty cart"
        shoppingCartService.removeProduct(shoppingCart, milk)
        then: "Exception should be thrown"
        def exception = thrown(RuntimeException)
        and: "With reasonable message"
        exception.message == "Shopping cart is empty"
    }
}
