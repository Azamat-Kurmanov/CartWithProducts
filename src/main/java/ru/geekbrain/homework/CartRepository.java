package ru.geekbrain.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CartRepository {
    private final CartFactory cartFactory;
    private ProductRepository productRepository;
    private List<Product> productList;

    public CartRepository(CartFactory cartFactory) {
        this.cartFactory = cartFactory;
    }

    public void createCart(){
        productRepository = new ProductRepository();
        productRepository.startProduct();
    }

    public void process(){
        createCart();
        System.out.println("\nFor choosing and adding the products into the 'Cart', specify 'ids' of the products with using comma: ");
        Scanner scanner1 = new Scanner(System.in);
        String secWord = scanner1.nextLine().trim();
        if (secWord != null && secWord != "") {
            String[] num = secWord.split(",");
            productList = new ArrayList<>();
            for (String n: num){
                productList.add(productRepository.getProductById(Integer.parseInt(n)));
            }
            cartFactory.addGoodIntoCart(productList);

            showCart();

            System.out.println("\nFor removing the 'Product' from your cart, you have to choose Ids of the products in your cart with using comma:");
            Scanner scanner2 = new Scanner(System.in);
            String thirdWord = scanner2.nextLine().trim();
            if (thirdWord!="" && thirdWord!=null){
                String[] numId = thirdWord.split(",");
                for (String id: numId){
                    Product product = productRepository.getProductById(Integer.parseInt(id));
                    if (product != null) {
//                        System.out.println("product: " + product.getProductInfo());
                        cartFactory.removeGoodFromCart(product);
                    }
                }
            }
            showCart();

            scanner2.close();
        }
        scanner1.close();
    }

    private void showCart(){
        if (cartFactory.getProductsFromTheCart().size()>0){
            System.out.println("The list of the products in your 'cart'\n");
            for (Product prods: cartFactory.getProductsFromTheCart()){
                System.out.println("Cart: " + prods.getProductInfo());
            }
        }
    }
}
