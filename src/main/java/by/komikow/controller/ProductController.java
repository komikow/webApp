package by.komikow.controller;

import by.komikow.dto.ProductResponse;
import by.komikow.service.serviceImplementation.ProductServiceImpl;
import by.komikow.service.serviceInterface.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductController {
    private ProductService productService = new ProductServiceImpl();


    public List<ProductResponse> readProducts() {
        return productService.readProductList();
    }

    public void createProduct(String productName, String productDescription, BigDecimal productPrice, int productQuantity, int productFkUnit) {
        productService.createProduct(productName, productDescription, productPrice, productQuantity, productFkUnit);
    }

    public void updateQuantityOfProduct(int id, int newQuantity) {
        productService.updateQuantityOfProduct(id, newQuantity);
    }

    public void deleteProductById(int id) {
        productService.deleteProductById(id);
    }
}
