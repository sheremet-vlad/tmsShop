package com.teachmeskills.parser.productParser;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teachmeskills.entity.products.Product;
import java.io.File;

public final class ProductParser {

    public void marshal(Product product, final String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            objectMapper.writeValue(new File(path), product);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    public Product unmarshal(String path) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();
            return objectMapper.readValue(new File(path), Product.class);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return null;
    }
}
