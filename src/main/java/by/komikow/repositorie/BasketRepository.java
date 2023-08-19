package by.komikow.repositorie;

import by.komikow.entity.Basket;
import by.komikow.util.HibernateUtil;
import by.komikow.util.Utils;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BasketRepository {
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void createBasket(Map<Integer, Integer> shopMap, int customerId) {
        BigDecimal basketCost = Utils.findCostShoppingMap(shopMap);
        String basketSetOfGoods = Utils.createShoppingMap(shopMap);
        String query = "insert into basket (basket_set_of_goods, basket_cost, basket_fk_customer) " +
                "values ('" + basketSetOfGoods + "', " + basketCost + ", " + customerId + ")";
        Utils.executeRequest(query);
        System.out.println("Корзина товаров успешно добавлена");
    }

    public List<Basket> readBasket() {
        List<Basket> basketList = new ArrayList<>();
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery("select * from basket");
            while (resultSet.next()) {
                int basketId = resultSet.getInt("basket_id");
                String basketSetOfGoods = resultSet.getString("basket_set_of_goods");
                BigDecimal basketCost = resultSet.getBigDecimal("basket_cost");
                int fkCustomerId = resultSet.getInt("basket_fk_customer");
                Basket basket = new Basket(basketId, basketSetOfGoods, basketCost, fkCustomerId);
                basketList.add(basket);
            }
            return basketList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateIdCustomerOfBasket(int id, int newCustomer) {
        String query = "update basket set basket_fk_customer='" + newCustomer + "' where basket_id = " + id;
        Utils.executeRequest(query);
        System.out.println("Id клиента изменён. Новый id: " + newCustomer);
    }

    public void deleteBasket(int id) {
        String query = "delete from basket where basket_id=" + id;
        Utils.executeRequest(query);
        System.out.println("Корзина с id = " + id + " удалёна.");
    }
}
