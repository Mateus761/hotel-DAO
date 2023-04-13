package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataBaseConnection {

    public static Connection getConnection() {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/hotel",
                            "mateus", "porco761");
            System.out.println("connected");
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return connection;
    }
}
