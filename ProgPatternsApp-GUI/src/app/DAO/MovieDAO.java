package app.DAO;

import app.model.Movie;
import java.sql.*;
import java.util.*;

public class MovieDAO {

    public ArrayList<Movie> getMovies() {
        ArrayList<Movie> movies = new ArrayList<>();

        String sql = "SELECT * FROM Movies";

        try {
            Connection myCon = Database.getConnection();

            Statement stmnt = myCon.createStatement();
            ResultSet result = stmnt.executeQuery(sql);

            while (result.next()) {
                movies.add(new Movie(
                        result.getInt("movieID"),
                        result.getString("movieTitle"),
                        result.getString("movieDescription"),
                        result.getInt("releaseYear"),
                        result.getDouble("avgRating"),
                        result.getString("genre"),
                        result.getInt("directorID"),
                        result.getString("imagePath")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return movies;
    }

    public ArrayList<Movie> filterSearch(String filter, String column) {
        ArrayList<Movie> filteredMovies = new ArrayList<>();

        List<String> columns = List.of("movieTitle", "genre", "releaseYear");

        if(!columns.contains(column)) {
            throw new IllegalArgumentException("Invalid column name");
        }

        String sql = "SELECT * FROM Movies WHERE " + column + " = ?";

        try {
            Connection myCon = Database.getConnection();

            PreparedStatement stmnt = myCon.prepareStatement(sql);
            stmnt.setString(1, filter);
            ResultSet result = stmnt.executeQuery();

            while (result.next()) {
                filteredMovies.add(new Movie(
                        result.getInt("movieID"),
                        result.getString("movieTitle"),
                        result.getString("movieDescription"),
                        result.getInt("releaseYear"),
                        result.getDouble("avgRating"),
                        result.getString("genre"),
                        result.getInt("directorID"),
                        result.getString("imagePath")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return filteredMovies;
    }
}
