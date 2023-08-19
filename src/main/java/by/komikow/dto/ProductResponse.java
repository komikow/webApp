package by.komikow.dto;

import java.math.BigDecimal;

public class ProductResponse {
    private final int productId;

    private final String productName;

    private final String productDescription;

    private final BigDecimal productPrice;

    private final int productQuantity;

    private final String productUnit;

    public ProductResponse(int productId, String productName, String productDescription, BigDecimal productPrice, int productQuantity, String productUnit) {
        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productPrice = productPrice;
        this.productQuantity = productQuantity;
        this.productUnit = productUnit;
    }

    @Override
    public String toString() {
        return "ProductResponse: " +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", productPrice=" + productPrice +
                ", productQuantity=" + productQuantity +
                ", productUnit='" + productUnit;
    }
}
