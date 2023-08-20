package uk.ac.le.co2103.part2;

import java.util.ArrayList;
import java.util.List;

public class ShoppingList {
    private String name;
    private String imageUrl;
    private List<Product> productList;

    public ShoppingList(String name, String image) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.productList = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void addProduct(String name, int quantity, String unit) {
        Product product = new Product(name, quantity, unit);
        productList.add(product);
    }
}