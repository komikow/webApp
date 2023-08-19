package by.komikow.util;

import by.komikow.entity.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class HibernateUtil {
    private Connection connection;
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/webApp?serverTimezone=Europe/Minsk&useSSL=false";
    private static final String USERNAME = "postgres";
    private static final String PASSWORD = "Qwety5";

    private Connection JDBCUtilConnection() {
        try {
            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (SQLException utilSqlException) {
            utilSqlException.printStackTrace();
        }
        return connection;
    }

    public Connection getJDBCUtilConnection() {
        return JDBCUtilConnection();
    }

}
