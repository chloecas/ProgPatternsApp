package app.DAO;

import app.model.Rating;
import java.sql.*;
import java.util.*;

public class RatingsDAO {

    public List<Rating> getAllRatings() {
        ArrayList<Rating> ratings = new ArrayList<>();

        String sql = "SELECT ratingsID, movieID, userID, rating FROM Ratings";

        try {
            Connection myCon = Database.getConnection();

            Statement stmnt = myCon.createStatement();
            ResultSet result = stmnt.executeQuery(sql);

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

        try{
            Connection myCon = Database.getConnection();
            PreparedStatement stmnt = myCon.prepareStatement(sql);
            stmnt.setInt(1, id);
            ResultSet result = stmnt.executeQuery();

            while(result.next()){
                String username = result.getString("username");
                double rating = result.getDouble("rating");

                ratings.put(username, rating);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return ratings;
    }
}
