package com.teachmeskills.parser.shopParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teachmeskills.entity.shop.Shop;
import com.teachmeskills.entity.shop.ShopSize;
import com.teachmeskills.entity.shop.Statuses;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class Parser {
    public static void main(String[] args) throws IOException {
        Shop shop = new Shop();
        shop.setName("Euroopt");
        shop.setAddress("Nalibokskaya street 36");
        shop.setShopSize(ShopSize.Super);
        shop.setStatuses(Arrays.asList(Statuses.Open, Statuses.Inventory));
        convertObjectToJson(shop);
        System.out.println(createObjectFromJson("shop1.json"));
    }

    public static void convertObjectToJson(Shop object) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File("shop.json"), object);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Shop createObjectFromJson(String path) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(path), Shop.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
