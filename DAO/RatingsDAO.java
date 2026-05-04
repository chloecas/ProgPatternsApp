package app.DAO;

import app.model.Rating;
import app.model.User;

import java.sql.*;
import java.util.*;

public class RatingsDAO {

    public List<Rating> getAllRatings() {
        ArrayList<Rating> ratings = new ArrayList<>();

        String sql = "SELECT ratingsID, movieID, userID, rating FROM Ratings";

        try (Connection myCon = Database.getConnection();
             Statement stmnt = myCon.createStatement();
             ResultSet result = stmnt.executeQuery(sql)) {

            while(result.next()){
                ratings.add(new Rating(
                        result.getInt("ratingsID"),
                        result.getInt("movieID"),
                        result.getInt("userID"),
                        result.getDouble("rating")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ratings;
    }

    public Map<String, Double> getRatingsByMovie(int id){
        LinkedHashMap<String, Double> ratings = new LinkedHashMap<>();

        String sql = """
            SELECT u.username, r.rating 
            FROM Ratings r
            JOIN Users u ON r.userID = u.userID
            WHERE movieID = ?
            """;

        try (Connection myCon = Database.getConnection();
             PreparedStatement stmnt = myCon.prepareStatement(sql)) {

            stmnt.setInt(1, id);

            try(ResultSet result = stmnt.executeQuery()) {
                while (result.next()) {
                    String username = result.getString("username");
                    double rating = result.getDouble("rating");

                    ratings.put(username, rating);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ratings;
    }

    public Map<Integer, Double> getRatingsByUser(int id){
        LinkedHashMap<Integer, Double> ratings = new LinkedHashMap<>();

        String sql = """
            SELECT r.userID, r.rating, m.movieTitle 
            FROM Ratings 
            JOIN Movies ON m.movieID = r.movieID
            WHERE userID = ?
            """;

        try (Connection myCon = Database.getConnection();
             PreparedStatement stmnt = myCon.prepareStatement(sql)) {

            stmnt.setInt(1, id);

            try(ResultSet result = stmnt.executeQuery()) {
                while (result.next()) {
                    int userID = result.getInt("userID");
                    double rating = result.getDouble("rating");

                    ratings.put(userID, rating);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ratings;
    }
}
