package com.example.onlinestore;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {


    private static final String JDBC_MYSQL_HOST = "jdbc:mysql://localhost:3306/";
    private static final String DB_NAME = "online_store";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "DaviDOMOTOLA1@";
    private static String driver = "com.mysql.cj.jdbc.Driver";


    public static Connection getConnection() {

        try {
            loadDriver(driver);
            return DriverManager.getConnection(JDBC_MYSQL_HOST + DB_NAME, USERNAME, PASSWORD);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private static void loadDriver(String dbDriver) {
        try {
            Class.forName(dbDriver);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}