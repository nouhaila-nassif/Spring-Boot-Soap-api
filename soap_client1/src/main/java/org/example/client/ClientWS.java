package org.example.client;
import proxy.Product;
import proxy.ProductWS;
import proxy.ProductWebService;

import java.util.List;

public class ClientWS {
    public static void main(String[] args) {
        ProductWebService proxy =new ProductWS().getProductWebServicePort();
        System.out.println(proxy.sellingPrice(400.00));
        System.out.println("-----------------------------------------------");
        Product product = proxy.getProduct(4);
        System.out.println(product.getName());
        System.out.println(product.getPrice());
        System.out.println("-----------------------------------------------");
        List<Product>products=proxy.productList();
        products.forEach(product1 -> {
            System.out.println(product1.getName());
            System.out.println(product1.getPrice());
                }
        );

    }
}
