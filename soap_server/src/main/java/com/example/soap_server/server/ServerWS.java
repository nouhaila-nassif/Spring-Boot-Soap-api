package com.example.soap_server.server;

import com.example.soap_server.Services.ProductWebService;
import jakarta.xml.ws.Endpoint;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServerWS {

    @Bean
    public ProductWebService productWebService() {
        return new ProductWebService(); // Remove this line and let Spring manage the instance
    }

    @Bean
    public Endpoint productWebServiceEndpoint(ProductWebService productWebService) {
        String url = "http://localhost:8090/product";
        Endpoint endpoint = Endpoint.publish(url, productWebService);
        System.out.println(url + " deployed");
        return endpoint;
    }
}
