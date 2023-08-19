package by.komikow.controller;

import by.komikow.dto.OrderResponse;
import by.komikow.service.serviceImplementation.OrderServiceImpl;
import by.komikow.service.serviceInterface.OrderService;

import java.time.LocalDate;
import java.util.List;

public class OrderController {
    private OrderService orderService = new OrderServiceImpl();

    public void createOrder(LocalDate orderDate, int fkBasket, int fkStatus) {
        orderService.createOrder(orderDate, fkBasket, fkStatus);
    }

    public List<OrderResponse> readOrders() {
        return orderService.readOrders();
    }

    public void updateStatusOrderById(int id, int newStatusId) {
        orderService.updateStatusOrderById(id, newStatusId);
    }

    public List<OrderResponse> findOrderByDate(LocalDate date) {
        return orderService.findOrderByDate(date);
    }

    public List<OrderResponse> findOrderByStatus(int statusId) {
        return orderService.findOrderByStatus(statusId);
    }

    public void deleteOrderById(int id) {
        orderService.deleteOrderById(id);
    }
}
