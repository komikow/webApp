package by.komikow.util;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Utils {
    static HibernateUtil hibernateUtil = new HibernateUtil();

    public static void executeRequest(String query) {
        try {
            hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeUpdate(query);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCustomerNameByFkId(int customerId) {
        String customerName = null;
        String query = "select customer_name from customers where customer_id = " + customerId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                customerName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return customerName;
    }

    public static int getBasketCustomerNameByFkId(int basketId) {
        int idCustomer = 0;
        String query = "select basket_fk_customer from basket where basket_id = " + basketId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                idCustomer = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return idCustomer;
    }

    public static BigDecimal getProductPriceByFkId(int productId) {
        BigDecimal productPrice = null;
        String query = "select product_price from products where product_id = " + productId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                productPrice = resultSet.getBigDecimal(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return productPrice;
    }

    public static String getStatusNameByFkId(int statusId) {
        String statusName = null;
        String query = "select status_type from status where status_id = " + statusId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                statusName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return statusName;
    }

    public static String getUnitNameByFkId(int unitId) {
        String unitName = null;
        String query = "select unit_name from units where unit_id = " + unitId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                unitName = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return unitName;
    }

    public static String createShoppingMap(Map<Integer, Integer> shopList) {
        Map<Integer, Integer> map = new HashMap<>(shopList);
        return map.toString();
    }

    public static BigDecimal findCostShoppingMap(Map<Integer, Integer> shopList) {
        int productId = 0;
        int quantity = 0;
        BigDecimal positionValue;
        BigDecimal basketValue = BigDecimal.valueOf(0);
        for (Map.Entry<Integer, Integer> entry : shopList.entrySet()) {
            productId = entry.getKey();
            quantity = entry.getValue();
            positionValue = getProductPriceByFkId(productId).multiply(BigDecimal.valueOf(quantity));
            basketValue = basketValue.add(positionValue);
        }
        return basketValue;
    }

    public static String getBasketOrderListByFkId(int basketId) {
        String basketList = null;
        String query = "select basket_set_of_goods from basket where basket_id = " + basketId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                basketList = resultSet.getString(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return basketList;
    }

    public static BigDecimal findCostById(int basketId) {
        BigDecimal sum = BigDecimal.valueOf(0);
        String query = "select basket_cost from basket where basket_id = " + basketId;
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery(query);
            while (resultSet.next()) {
                sum = BigDecimal.valueOf(resultSet.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return sum;
    }
}
