package config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class MyConfig {

    private static final String url = "jdbc:mysql://localhost:3306/db_toko";
    private static final String username = "root";
    private static final String pass = "";

    protected static Connection connect;
    protected static PreparedStatement preparedStatement;
    protected static ResultSet resultSet;
    protected static String query;

    public static void getConnection() {
        try {
            connect = DriverManager.getConnection(url, username, pass);
            System.out.println("Connected");
        } catch (SQLException e) {
            e.printStackTrace();

        }
    }
}