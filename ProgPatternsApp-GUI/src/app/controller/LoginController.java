package app.controller;

import javafx.scene.control.TextField;
import javafx.event.ActionEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import app.model.LoginService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.Pane;

public class LoginController {

	@FXML
	private Pane loginPage;

	@FXML
	private TextField username,fName,lName,sUsername,age,email;

	@FXML
	private PasswordField password,sPassword;

	@FXML
	private Button submit;

	private LoginService login;

	public void initialize() {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:MovieReviewApp.db");
			login = new LoginService(con);
			System.out.println("Connected to database successfully");
			Statement st2 = con.createStatement();
			ResultSet res2 = st2.executeQuery("select * from Users");
			System.out.println(res2);
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
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
    public void handleClick(ActionEvent event) {
        System.out.println("Account clicked!");
        loginPage.setVisible(true);

    }

}
