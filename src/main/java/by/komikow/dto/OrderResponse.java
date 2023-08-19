package by.komikow.dto;

import java.math.BigDecimal;
import java.time.LocalDate;


public class OrderResponse {
    private final int orderId;

    private final LocalDate orderDate;

    private final String basketSet;

    private final BigDecimal basketCost;

    private final String customerName;

    private final String statusType;

    public OrderResponse(int orderId, LocalDate orderDate, String basketSet, BigDecimal basketCost, String customerName, String statusType) {
        this.orderId = orderId;
        this.orderDate = orderDate;
        this.basketSet = basketSet;
        this.basketCost = basketCost;
        this.customerName = customerName;
        this.statusType = statusType;
    }

    @Override
    public String toString() {
        return "OrderResponse{" +
                "orderId=" + orderId +
                ", orderDate=" + orderDate +
                ", basketSet='" + basketSet + '\'' +
                ", basketCost=" + basketCost +
                ", customerName='" + customerName + '\'' +
                ", statusType='" + statusType;
    }
}
