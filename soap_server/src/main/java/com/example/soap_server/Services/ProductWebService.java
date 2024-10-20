package com.example.soap_server.Services;

import com.example.soap_server.models.Product;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@WebService
@Service
public class ProductWebService {

    @Autowired
    private ProductService productService;

    @WebMethod
    public String createProduct(
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name,
            @WebParam(name = "price") double price) {
        Product product = new Product(code, name, price, null);
        productService.createProduct(product);
        return "Product created successfully!";
    }

    @WebMethod
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @WebMethod
    public Product getProductByCode(@WebParam(name = "code") int code) {
        return productService.getProductByCode(code);
    }

    @WebMethod
    public String updateProduct(
            @WebParam(name = "code") int code,
            @WebParam(name = "name") String name,
            @WebParam(name = "price") double price) {
        Product updatedProduct = new Product(code, name, price, null);
        Product product = productService.updateProduct(code, updatedProduct);
        if (product != null) {
            return "Product updated successfully!";
        } else {
            return "Product not found!";
        }
    }

    @WebMethod
    public String deleteProduct(@WebParam(name = "code") int code) {
        boolean isDeleted = productService.deleteProduct(code);
        if (isDeleted) {
            return "Product deleted successfully!";
        } else {
            return "Product not found!";
        }
    }
}