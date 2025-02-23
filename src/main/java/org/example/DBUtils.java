package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {

    private static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static String dbUserName = "postgres";
    private static String dbPassword = "fox4234";


    public static Connection getConnection() {


        Connection connection;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);
            System.out.println("Соединение с базой.");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
