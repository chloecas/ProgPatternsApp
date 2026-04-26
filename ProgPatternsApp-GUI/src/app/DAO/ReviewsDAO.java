package app.DAO;

import java.sql.*;
import java.util.*;
import app.model.Review;

public class ReviewsDAO {
    public List<Review> getAllReviews() {
        ArrayList<Review> reviews = new ArrayList<>();

        String sql = "SELECT reviewID, rating, comment, creationDate, userID, movieID FROM Reviews";

        try {
            Connection myCon = Database.getConnection();

            Statement stmnt = myCon.createStatement();
            ResultSet result = stmnt.executeQuery(sql);

            while(result.next()){
                reviews.add(new Review(
                        result.getInt("reviewID"),
                        result.getDouble("rating"),
                        result.getString("comment"),
                        result.getString("creationDate"),
                        result.getInt("userID"),
                        result.getInt("movieID")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }

    public List<String> getReviewsByMovie(int id){
        ArrayList<String> reviews = new ArrayList<>();

        String sql = """
            SELECT u.username, r.rating, r.comment, r.creationDate
            FROM Reviews r
            JOIN Users u ON r.userID = u.userID
            WHERE r.movieID = ?
            """;
        try {
            Connection myCon = Database.getConnection();
            PreparedStatement stmnt = myCon.prepareStatement(sql);
            stmnt.setInt(1, id);
            ResultSet result = stmnt.executeQuery();

            while(result.next()){
                String formatted = result.getString("username") + ": "
                + result.getString("comment") + " (Rating: " + result.getDouble("rating") + ")"
                + " - " + result.getString("creationDate");

                reviews.add(formatted);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return reviews;
    }
}
