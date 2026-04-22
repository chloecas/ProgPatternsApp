package app.DAO;

import java.sql.*;

public class Database {
    private static final String URL = "jdbc:sqlite:ProgPatternsApp-GUI/MovieReviewApp.db";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL);
    }
}
