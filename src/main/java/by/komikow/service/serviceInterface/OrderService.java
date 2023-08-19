package by.komikow.service.serviceInterface;

import by.komikow.dto.OrderResponse;

import java.time.LocalDate;
import java.util.List;

public interface OrderService {
    public void createOrder(LocalDate orderDate, int fkBasket, int fkStatus);

    public List<OrderResponse> readOrders();

    public void updateStatusOrderById(int id, int newStatusId);

    public void deleteOrderById(int id);

    public List<OrderResponse> findOrderByDate(LocalDate date);

    public List<OrderResponse> findOrderByStatus(int statusId);
}
