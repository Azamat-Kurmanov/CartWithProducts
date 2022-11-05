package ru.geekbrain.homework;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    private int cartSize = 5;
    private List<Product> productList;
    private String[] listOfProducts = {
                                        "Сахар", "Мука", "Яблоки",
                                        "Картошка", "Морковь", "Сыр",
                                        "Колбаса", "Молоко", "Мясо",
                                        "Творог", "Апельсин", "Груша",
                                        "Селедка", "Конфеты", "Огурцы"
                                      };

    public void startProduct(){
        int productCount = 0;
        productList = new ArrayList<>();
        while(productCount < cartSize){
            int indx = (int) (Math.random() * 15);
            double price = Math.round(Math.random() * 5000);
            Product product = new Product();
            product.setId(productCount);
            product.setName(listOfProducts[indx]);
            product.setPrice(price);
            productList.add(product);
            productCount++;
        }

        getListOfProducts();
    }

    public List<Product> getListOfProducts(){
        System.out.println("The list of the products:\n");
        for (Product prod: productList){
            System.out.println("products: " + prod.getProductInfo());
        }
        return productList;
    }

    public Product getProductById(int id){
        for (Product product: productList){
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }
}
