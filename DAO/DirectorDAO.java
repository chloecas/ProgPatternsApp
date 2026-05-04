package app.DAO;

import java.sql.*;
import java.util.*;
import app.model.Director;

public class DirectorDAO {
    public List<Director> getAllDirectors() {
        ArrayList<Director> directors = new ArrayList<>();

        String sql = "SELECT directorID, directorName, directorBirthDate, directorBio FROM Directors";

        try (Connection myCon = Database.getConnection();
             Statement stmnt = myCon.createStatement();
             ResultSet result = stmnt.executeQuery(sql)) {

            while(result.next()){
                directors.add(new Director(
                        result.getInt("directorID"),
                        result.getString("directorName"),
                        result.getString("directorBirthDate"),
                        result.getString("directorBio")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return directors;
    }

    public Director getDirectorByMovie(int id) {
        String sql = """
                SELECT d.directorID, d.directorName, d.directorBirthDate, d.directorBio
                FROM Directors d
                JOIN Movies m ON d.directorID = m.directorID
                WHERE m.movieID = ?
                """;

        try (Connection myCon = Database.getConnection();
             PreparedStatement stmnt = myCon.prepareStatement(sql)) {

            stmnt.setInt(1, id);

            try(ResultSet result = stmnt.executeQuery()) {
                if (result.next()) {
                    return new Director(
                            result.getInt("directorID"),
                            result.getString("directorName"),
                            result.getString("directorBirthDate"),
                            result.getString("directorBio")
                    );
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
