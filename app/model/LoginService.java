package app.model;

import app.DAO.UserDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

public class LoginService {
	private UserDAO userDAO;

	public LoginService(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public boolean authenticate(String user, String pass) throws Exception {
		if(userDAO.authenticate(user,pass)) {
			return true;
		} else {
			throw new Exception("Invalid credentials...");
		}
	}

	public boolean usernameAvailability(String user) throws Exception {
		if(userDAO.usernameAvailability(user)) {
			return true;
		} else {
			throw new Exception("Username unavailable");
		}
	}

	public void createAccount(String firstN, String lastN, int age, String email, String user, String pass) throws SQLException {
		userDAO.createAccount(firstN, lastN, age, email, user, pass);
	}
}
