package org.example;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DBUtils {
    // класс отвечает за соединения с нашей БД

    private static String dbUrl = "jdbc:postgresql://localhost:5432/postgres";
    private static String dbUserName = "postgres";
    private static String dbPassword = "fox4234";


    public static Connection getConnection() {


        Connection connection;
        try {
            connection = DriverManager.getConnection(dbUrl, dbUserName, dbPassword);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return connection;
    }
}
