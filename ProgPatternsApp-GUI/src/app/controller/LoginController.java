package app.controller;

import app.DAO.UserDAO;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.event.ActionEvent;

import app.model.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

public class LoginController {

	@FXML
	private Pane signInPane;

	@FXML
	private TextField username,fName,lName,sUsername,age,email;

	@FXML
	private PasswordField password,sPassword;

	@FXML
	private Label signInText;

	@FXML
	private Button signIn;

	private LoginService login;

	public void initialize() {
		try {
			UserDAO userDAO = new UserDAO();
			login = new LoginService(userDAO);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void loginFunction() {
		String user = username.getText();
		String pass = password.getText();

		try {
			if(login.authenticate(user, pass)) {
				System.out.println("Login successful!");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void signInFunction() {
		String firstName = fName.getText();
		String lastName = lName.getText();
		int Age = Integer.parseInt(age.getText());
		String Email = email.getText();
		String sUser = sUsername.getText();
		String sPass = sPassword.getText();

		try {
			login.createAccount(firstName,lastName,Age,Email,sUser,sPass);
			System.out.println("Sign in successful!");
			signInPane.setVisible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void signInPane() {
		signInPane.setVisible(true);
	}

	@FXML
	private void goBackLogin() {
		signInPane.setVisible(false);
	}
}
