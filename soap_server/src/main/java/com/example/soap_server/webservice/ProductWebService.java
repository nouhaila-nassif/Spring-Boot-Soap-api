package com.example.soap_server.webservice;

import com.example.soap_server.models.Product;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebService;
import java.util.Date;
import java.util.List;

@WebService(serviceName = "ProductWS")
public class ProductWebService {
    @WebMethod(operationName = "sellingPrice")
    public Double sellingPrice(@WebParam(name = "Price") Double price){
        return price*1.5;
    }
    @WebMethod
    public Product getProduct(Integer code){
        return new Product(code, "Table", 300.00, new Date());
    }
    @WebMethod
    public List<Product> productList(){
        return List.of(
                new Product(1, "Table", 300.00, new Date()),
                new Product(2, "Pen", 3.00, new Date()),
                new Product(3, "Cheese", 30.00, new Date()),
                new Product(4, "Bread", 6.00, new Date())
        );
    }
}
