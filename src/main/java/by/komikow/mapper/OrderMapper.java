package by.komikow.mapper;

import by.komikow.dto.OrderResponse;
import by.komikow.entity.Order;
import by.komikow.util.Utils;

import java.math.BigDecimal;
import java.time.LocalDate;

public class OrderMapper {

    public OrderResponse buildOrderResponse(Order order) {
        int orderId = order.getOrderId();
        LocalDate orderDate = order.getOrderDate();
        int basketId = order.getFkBasket();
        String basketSet = Utils.getBasketOrderListByFkId(basketId);
        BigDecimal basketCost = Utils.findCostById(basketId);
        int customerId = Utils.getBasketCustomerNameByFkId(basketId);
        String customerName = Utils.getCustomerNameByFkId(customerId);
        String statusType = Utils.getStatusNameByFkId(order.getFkStatus());
        return new OrderResponse(orderId, orderDate, basketSet, basketCost, customerName, statusType);
    }
}
