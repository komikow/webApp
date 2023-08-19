package by.komikow.repositorie;

import by.komikow.dto.ProductResponse;
import by.komikow.entity.Product;
import by.komikow.mapper.ProductMapper;
import by.komikow.util.HibernateUtil;
import by.komikow.util.Utils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void createProduct(String productName, String productDescription, BigDecimal productPrice, int productQuantity, int productFkUnit) {
        String query = "insert into products (product_name, product_description, product_price, product_quantity, product_fk_unit) " +
                "values ('" + productName + "', '" + productDescription + "'," + productPrice + ", " + productQuantity + ", " + productFkUnit + ")";
        Utils.executeRequest(query);
        System.out.println("Товар успешно добавлен");
    }

    public List<ProductResponse> readProducts() {
        List<ProductResponse> productList = new ArrayList<>();
        ProductMapper productMapper = new ProductMapper();
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery("select * from products");
            while (resultSet.next()) {
                int productId = resultSet.getInt("product_id");
                String productName = resultSet.getString("product_name");
                String productDescription = resultSet.getString("product_description");
                BigDecimal productPrice = resultSet.getBigDecimal("product_price");
                int productQuantity = resultSet.getInt("product_quantity");
                int productFkUnit = resultSet.getInt("product_fk_unit");
                Product product = new Product(productId, productName, productDescription, productPrice, productQuantity, productFkUnit);
                productList.add(productMapper.buildProductResponse(product));
            }
            return productList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateQuantityOfProduct(int id, int newQuantity) {
        String query = "update products set product_quantity=" + newQuantity + " where product_id = " + id;
        Utils.executeRequest(query);
        System.out.println("Количество товара изменено. Новое количество товара = " + newQuantity);
    }

    public void deleteProductById(int id) {
        String query = "delete from products where product_id=" + id;
        Utils.executeRequest(query);
        System.out.println("Товар с id = " + id + " удалён.");
    }
}
