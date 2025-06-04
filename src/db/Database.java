package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static final String URL = "jdbc:mysql://localhost:3306/project_manager";
    private static final String USER = "root";
    private static final String PASSWORD = ""; // Ganti dengan password MySQL Anda jika ada

    public static Connection connect() {
        try {
            // Memuat driver JDBC
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Membuat koneksi ke database
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            System.err.println("Driver JDBC tidak ditemukan.");
            e.printStackTrace();
            return null;
        } catch (SQLException e) {
            System.err.println("Koneksi ke database gagal.");
            e.printStackTrace();
            return null;
        }
    }
}
