package controller;

import java.sql.*;

public class UserManager extends BaseManager {

    public boolean register(String username, String password) {
        try {
            String sql = "INSERT INTO users (username, password) VALUES (?, ?)";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // ❗ Disarankan hashing di sini
            stmt.executeUpdate();
            return true;
        } catch (SQLException e) {
            System.err.println("Register error: " + e.getMessage());
            return false;
        }
    }

    public boolean login(String username, String password) {
        try {
            String sql = "SELECT * FROM users WHERE username=? AND password=?";
            PreparedStatement stmt = db.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password); // ❗ Harus konsisten dengan hashed password
            ResultSet rs = stmt.executeQuery();
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Login error: " + e.getMessage());
            return false;
        }
    }
}

