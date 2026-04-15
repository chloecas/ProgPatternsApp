package app.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoginService {
	private Connection myCon;

	public LoginService(Connection con) {
		this.myCon = con;
	}

	public boolean authenticate(String user, String pass) throws Exception {
		PreparedStatement auth = myCon.prepareStatement("SELECT username FROM Users WHERE username = ? AND password = ?");
		auth.setString(1,  user);
		auth.setString(2, pass);

		ResultSet result = auth.executeQuery();
		if(result.next()) {
			return true;
		} else {
			throw new Exception("Invalid credentials...");
		}
	}

	public boolean usernameAvailability(String user) throws Exception {
		PreparedStatement avail;

		avail = myCon.prepareStatement("SELECT username FROM Users WHERE username = ?");
		avail.setString(1,  user);

		ResultSet result = avail.executeQuery();
		return !result.next();
	}

	public void createAccount(String firstN, String lastN, int age, String email, String user, String pass) throws SQLException {

		String sql = "INSERT INTO Users(username, email, joinDate, age, firstName, lastName, password) " + "VALUES (?, ?, ?, ?, ?, ?, ?)";

		PreparedStatement create = myCon.prepareStatement(sql);
			create.setString(1, user);
			create.setString(2, email);
			create.setString(3, LocalDate.now().toString());
			create.setInt(4, age);
			create.setString(5, firstN);
			create.setString(6, lastN);
			create.setString(7, pass);

			create.executeUpdate();
	}
}
