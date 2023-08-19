package by.komikow.repositorie;

import by.komikow.dto.OrderResponse;
import by.komikow.entity.Order;
import by.komikow.mapper.OrderMapper;
import by.komikow.util.HibernateUtil;
import by.komikow.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void createOrder(LocalDate orderDate, int fkBasket, int fkStatus) {
        String query = "insert into orders (order_date, order_fk_basket, order_fk_status)" +
                "values ('" + java.sql.Date.valueOf(orderDate) + "'," + fkBasket
                + "," + fkStatus + ")";
        Utils.executeRequest(query);
        System.out.println("Заказ успешно создан");
    }

    public List<OrderResponse> readOrders() {
        List<OrderResponse> responseList = new ArrayList<>();
        Order order;
        OrderMapper orderMapper;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery("select * from orders");
            while (resultSet.next()) {
                int orderId = resultSet.getInt(1);
                LocalDate date = resultSet.getDate(2).toLocalDate();
                int fkBasket = resultSet.getInt(3);
                int fkStatus = resultSet.getInt(4);
                order = new Order(orderId, date, fkBasket, fkStatus);
                orderMapper = new OrderMapper();
                OrderResponse orderResponse = orderMapper.buildOrderResponse(order);
                responseList.add(orderResponse);
            }
            return responseList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateStatusOrderById(int id, int newStatusId) {
        String query = "update orders set order_fk_status=" + newStatusId + " where order_id = " + id;
        Utils.executeRequest(query);
        System.out.println("Статус заказа изменен.");
    }

    public void deleteOrderById(int id) {
        String query = "delete from orders where order_id=" + id;
        Utils.executeRequest(query);
        System.out.println("Заказ с id = " + id + " удалён.");
    }

    public List<OrderResponse> findOrderByStatus(int status_id) {
        List<OrderResponse> orderList = new ArrayList<>();
        String query = "select * from orders where order_fk_status = " + status_id;
        Order order;
        OrderMapper orderMapper = new OrderMapper();
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                order = new Order(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
                OrderResponse orderResponse = orderMapper.buildOrderResponse(order);
                orderList.add(orderResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }

    public List<OrderResponse> findOrderByDate(LocalDate date) {
        List<OrderResponse> orderList = new ArrayList<>();
        String query = "select * from orders where order_date = '" + java.sql.Date.valueOf(date) + "'";
        Order order;
        OrderMapper orderMapper;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                order = new Order(resultSet.getInt(1),
                        resultSet.getDate(2).toLocalDate(),
                        resultSet.getInt(3),
                        resultSet.getInt(4));
                orderMapper = new OrderMapper();
                OrderResponse orderResponse = orderMapper.buildOrderResponse(order);
                orderList.add(orderResponse);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return orderList;
    }
}
