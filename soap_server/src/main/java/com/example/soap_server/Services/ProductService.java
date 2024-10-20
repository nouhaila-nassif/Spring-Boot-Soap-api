package com.example.soap_server.Services;

import com.example.soap_server.Repositories.ProductRepository;
import com.example.soap_server.models.Product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    // Injecting the ProductRepository for database operations
    @Autowired
    private ProductRepository productRepository;

    // Create or add a new product
    public Product createProduct(Product product) {
        product.setDateCreation(new Date());  // Set creation date for the new product
        return productRepository.save(product); // Save the product to the database
    }

    // Retrieve all products
    public List<Product> getAllProducts() {
        return productRepository.findAll(); // Fetch all products from the database
    }

    // Retrieve a product by code
    public Product getProductByCode(int code) {
        return productRepository.findById((long) code).orElse(null); // Fetch product by ID from the database
    }

    // Update an existing product
    public Product updateProduct(int code, Product updatedProduct) {
        Optional<Product> existingProductOpt = productRepository.findById((long) code);
        if (existingProductOpt.isPresent()) {
            Product existingProduct = existingProductOpt.get();
            existingProduct.setName(updatedProduct.getName());
            existingProduct.setPrice(updatedProduct.getPrice());
            existingProduct.setDateCreation(new Date()); // Update creation date
            return productRepository.save(existingProduct); // Save the updated product to the database
        }
        return null; // Return null if product is not found
    }

    // Delete a product by code
    public boolean deleteProduct(int code) {
        if (productRepository.existsById((long) code)) {
            productRepository.deleteById((long) code); // Delete product by ID from the database
            return true;
        }
        return false; // Return false if product is not found
    }
}