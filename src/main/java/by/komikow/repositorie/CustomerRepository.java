package by.komikow.repositorie;

import by.komikow.entity.Customer;
import by.komikow.util.HibernateUtil;
import by.komikow.util.Utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    HibernateUtil hibernateUtil = new HibernateUtil();

    public void createCustomer(String name, String email) {
        String query = "insert into customers (customer_name, customer_email) " +
                "values ('" + name + "', '" + email + "')";
        Utils.executeRequest(query);
        System.out.println("Клиент успешно добавлен");
    }

    public List<Customer> readCustomers() {
        List<Customer> customerList = new ArrayList<>();
        try {
            ResultSet resultSet = hibernateUtil
                    .getJDBCUtilConnection()
                    .createStatement()
                    .executeQuery("select * from customers");
            while (resultSet.next()) {
                int id = resultSet.getInt("customer_id");
                String nameCustomer = resultSet.getString("customer_name");
                String emailCustomer = resultSet.getString("customer_email");
                Customer customer = new Customer(id, nameCustomer, emailCustomer);
                customerList.add(customer);
            }
            return customerList;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateEmailOfCustomer(int id, String newEmail) {
        String query = "update customers set customer_email='" + newEmail + "' where customer_id = " + id;
        Utils.executeRequest(query);
        System.out.println("Email клиента изменён. Новый email: " + newEmail);
    }

    public void deleteCustomer(int id) {
        String query = "delete from customers where customer_id=" + id;
        Utils.executeRequest(query);
        System.out.println("Клиент с id = " + id + " удалён.");
    }
}
