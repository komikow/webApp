package by.komikow.service.serviceInterface;

import by.komikow.dto.ProductResponse;

import java.math.BigDecimal;
import java.util.List;

public interface ProductService {
    public void createProduct(String productName, String productDescription, BigDecimal productPrice, int productQuantity, int productFkUnit);

    public List<ProductResponse> readProductList();

    public void updateQuantityOfProduct(int id, int newQuantity);

    public void deleteProductById(int id);
}
