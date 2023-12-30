package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConncect {
    public static final String DB_URL = "jdbc:postgresql:PatikaDev";
    public static final String DB_USER = "postgres";
    public static final String DB_PASSWORD = "root";
    public static void main(String[] args) {
        /* Bu şekilde bir işlem ile DB bağlantısı kurulabilir ama burada URL deki değişkenleri bir değişkende tutmak daha mantıklı olur.
        Connection connection = null;
        try {
            String url = "jdbc:postgresql:PatikaDev?user=postgres&password=root";
            connection = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        */

        // Bu şekilde kullanımı daha yakışıklı :)
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connection is successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    public static Connection connectDB(String DB_URL, String DB_USER, String DB_PASSWORD) {
        // Bu şekilde kullanımı daha yakışıklı :)
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            System.out.println("Database connection is successfully!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return connection;
    }
}
