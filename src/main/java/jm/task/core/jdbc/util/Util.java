package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Map;
import java.util.Properties;

public class Util {
    // реализуйте настройку соеденения с БД
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "root";
    private static final String DIALECT = "org.hibernate.dialect.MySQLDialect";
    private static final String DRIVER = "com.mysql.jdbc.Driver";


    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            System.out.println("Соединение с БД установлено");
        } catch (SQLException e) {
            System.out.println("Соединение с БД не установлено!!!");
            e.printStackTrace();
        }
        return connection;
    }

    // Hibernate configuration

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        Properties properties = new Properties();
        if (sessionFactory == null) {
            try {
                properties.setProperty("hibernate.connection.url", URL);
                properties.setProperty("dialect", DIALECT);
                properties.setProperty("hibernate.connection.username", USERNAME);
                properties.setProperty("hibernate.connection.password", PASSWORD);
                properties.setProperty("hibernate.connection.driver_class", DRIVER);
                properties.setProperty("show_sql", "true");
                properties.setProperty("hibernate.current_session_context_class", "thread");

                properties.setProperty("hibernate.hbm2ddl.auto", "");

                sessionFactory = new Configuration().addProperties(properties)
                        .addAnnotatedClass(User.class)
                        .buildSessionFactory();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return sessionFactory;
    }
}



