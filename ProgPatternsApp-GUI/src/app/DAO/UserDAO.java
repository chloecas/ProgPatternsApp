package app.DAO;

import app.model.User;
import java.sql.*;
import java.time.LocalDate;
import java.util.*;

public class UserDAO {

    public ArrayList<User> getUsers() {
        ArrayList<User> users = new ArrayList<>();

        String sql = "SELECT * FROM Users";

        try {
            Connection myCon = Database.getConnection();

            Statement stmnt = myCon.createStatement();
            ResultSet result = stmnt.executeQuery(sql);

            while (result.next()) {
                users.add(new User(
                        result.getInt("userID"),
                        result.getString("username"),
                        result.getString("password"),
                        result.getString("firstName"),
                        result.getString("lastName"),
                        result.getString("email"),
                        result.getInt("age"),
                        result.getDate("joinDate")
                ));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    public void createAccount(String firstN, String lastN, int age, String email, String user, String pass) throws SQLException {

        String sql = "INSERT INTO Users(username, email, joinDate, age, firstName, lastName, password) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

        try {
            Connection myCon = Database.getConnection();

            PreparedStatement create = myCon.prepareStatement(sql);
            create.setString(1, user);
            create.setString(2, email);
            create.setString(3, LocalDate.now().toString());
            create.setInt(4, age);
            create.setString(5, firstN);
            create.setString(6, lastN);
            create.setString(7, pass);

            create.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean usernameAvailability(String user) throws Exception {
        PreparedStatement avail;

        try {
            Connection myCon = Database.getConnection();
            avail = myCon.prepareStatement("SELECT username FROM Users WHERE username = ?");
            avail.setString(1, user);

            ResultSet result = avail.executeQuery();
            return result.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean authenticate(String user, String pass) throws Exception {
        try {
            Connection myCon = Database.getConnection();

            PreparedStatement auth = myCon.prepareStatement("SELECT username FROM Users WHERE username = ? AND password = ?");
            auth.setString(1, user);
            auth.setString(2, pass);

            ResultSet result = auth.executeQuery();
            return result.next();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public User getUser(String username) {
        User user = new User(0, null, null, null, null,null,0, null);

        try {
            Connection myCon = Database.getConnection();
            PreparedStatement findUser = myCon.prepareStatement("SELECT * FROM Users WHERE username = ?");
            findUser.setString(1, username);

            ResultSet result = findUser.executeQuery();
            while (result.next()) {
                user.setUserId(result.getInt("userID"));
                user.setUsername( result.getString("username"));
                user.setPassword(result.getString("password"));
                user.setFirstName(result.getString("firstName"));
                user.setLastName(result.getString("lastName"));
                user.setEmail(result.getString("email"));
                user.setAge(result.getInt("age"));
                user.setJoinDate(result.getDate("joinDate"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }
}
