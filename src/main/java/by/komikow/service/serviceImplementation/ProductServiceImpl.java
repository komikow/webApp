package by.komikow.service.serviceImplementation;

import by.komikow.dto.ProductResponse;
import by.komikow.repositorie.ProductRepository;
import by.komikow.service.serviceInterface.ProductService;

import java.math.BigDecimal;
import java.util.List;

public class ProductServiceImpl implements ProductService {
    private ProductRepository productRepository = new ProductRepository();

    @Override
    public void createProduct(String productName, String productDescription, BigDecimal productPrice, int productQuantity, int productFkUnit) {
        productRepository.createProduct(productName, productDescription, productPrice, productQuantity, productFkUnit);
    }

    @Override
    public List<ProductResponse> readProductList() {
        return productRepository.readProducts();
    }

    public void updateQuantityOfProduct(int id, int newQuantity) {
        productRepository.updateQuantityOfProduct(id, newQuantity);
    }

    @Override
    public void deleteProductById(int id) {
        productRepository.deleteProductById(id);
    }
}
