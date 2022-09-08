package com.teachmeskills.service.productService

import com.teachmeskills.entity.products.Chocolate
import com.teachmeskills.entity.products.Milk
import com.teachmeskills.entity.products.Product
import com.teachmeskills.entity.shop.Shop
import spock.lang.Specification

class ShopServiceTest extends Specification {
    def "test addProductToShop"() {
        given:
        ShopService shopService = new ShopService()

        Product product = new Milk(1, "Milk", 2.68, 3, "product", 1000);

        Shop shop = Mock()
        List<Product> productArrayList = new ArrayList<Product>()
        productArrayList << product
        shop.getProducts() >> productArrayList
        when:
        shopService.addProductToShop(shop, product, 2)
        shopService.addProductToShop(shop, product, 2)
        then:
        /// There should be only one product in shop.
        shop.products.size() == 1
        /// And this should be milk.
        shop.products.stream()
                .any(ProductInShop -> ProductInShop.name == product.name)
        /// With quantity equal to product quantity in shop + added quantity
        shop.products.stream()
                .any(ProductInShop -> ProductInShop.quantity == 7)
    }

    def "test addProductToShop with empty list"() {
        given:
        ShopService shopService = new ShopService()

        Product product = new Milk(1, "Milk", 2.68, 3, "product", 1000);

        Shop shop = Mock()
        shop.getProducts() >> new ArrayList<Product>()
        when:
        shopService.addProductToShop(shop, product, 2)
        shopService.addProductToShop(shop, product, 2)
        then:
        /// There should be only one product in shop.
        shop.products.size() == 1
        /// And this should be milk.
        shop.products.stream()
                .any(ProductInShop -> ProductInShop.name == product.name)
        /// With quantity equal to 2
        shop.products.stream()
                .any(ProductInShop -> ProductInShop.quantity == 4)
    }

    def "test addProductToShop with multiple products"() {
        given:
        ShopService shopService = new ShopService()

        Product chocolate = new Chocolate(2, "Chocolate", 3.51, 10, "product")
        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << chocolate
        shop.getProducts() >> productList
        when:
        shopService.addProductToShop(shop, milk, 2)
        shopService.addProductToShop(shop, chocolate, 1)
        then:
        /// Should be two products in shop - Milk and Chocolate
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(chocolate.name, 11), new Tuple(milk.name, 2)]
    }

    def "test editQuantityProductInShop"() {
        given:
        ShopService shopService = new ShopService()

        Product chocolate = new Chocolate(2, "Chocolate", 3.51, 10, "product")

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << chocolate
        shop.getProducts() >> productList
        when: "Subtracting 100 bars of chocolate from 10 in shop"
        shopService.editQuantityProductInShop(shop, chocolate, 100)
        then:
        thrown(RuntimeException)
        /// And amount of chocolate should be same
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(chocolate.name, 10)]
    }

    def "test editQuantityProductInShop with invalid product"() {
        given:
        ShopService shopService = new ShopService()

        Product chocolate = new Chocolate(2, "Chocolate", 3.51, 10, "product")
        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << chocolate
        shop.getProducts() >> productList
        when: "Subtracting 100 bars of chocolate from 10 in shop"
        shopService.editQuantityProductInShop(shop, milk, 100)
        then:
        thrown(RuntimeException)
        /// And amount of chocolate should be same
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(chocolate.name, 10)]
    }

    def "test removeProduct with wrong product"() {
        given:
        ShopService shopService = new ShopService()

        Product chocolate = new Chocolate(2, "Chocolate", 3.51, 10, "product")
        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << chocolate
        shop.getProducts() >> productList
        when: "Removing wrong product"
        shopService.removeProduct(shop, milk)
        then: "Expecting throw"
        def exception = thrown(RuntimeException)
        and: "With exact message"
        exception.message == "This product " + milk.getName() + " is not available in the store"
        and: "List of products should be unchanged"
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(chocolate.name, 10)]
    }

    def "test removeProduct if products list in shop is empty"() {
        given:
        ShopService shopService = new ShopService()

        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        shop.getProducts() >> productList
        when: "Removing from empty list in shop"
        shopService.removeProduct(shop, milk)
        then: "Exception with clear message"
        def exception = thrown(RuntimeException)
        exception.message == "There is no products in this shop"
    }

    def "test searchProductByName"() {
        given:
        ShopService shopService = new ShopService()

        Product chocolate = new Chocolate(2, "Chocolate", 3.51, 10, "product")
        Product milk = new Milk(1, "Milk", 2.68, 3, "product", 1000)

        Shop shop = Mock()
        List<Product> productList = new ArrayList<>()
        productList << chocolate
        productList << milk
        shop.getProducts() >> productList
        when: "Searching for chocolate"
        def founded = shopService.searchProductByName(shop, chocolate)
        then: "Product should be chocolate"
        founded == chocolate
        when: "Searching for milk"
        founded = shopService.searchProductByName(shop, milk)
        then: "Product should be milk"
        founded == milk
        and: "List should be unchanged"
        shop.products.collect { new Tuple(it.name, it.quantity) }
                ==~ [new Tuple(chocolate.name, 10), new Tuple(milk.name, 3)]

    }
}
