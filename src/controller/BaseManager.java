package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class BaseManager {
    protected Connection db;

    public BaseManager() {
        try {
            // Ganti URL, user, password sesuai database kamu
            String url = "jdbc:mysql://localhost:3306/project_manager";
            String user = "root";
            String password = "";

            db = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
