package app.controller;

import java.sql.Connection;
import java.sql.DriverManager;

import app.model.LoginService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

public class LoginController {

	 @FXML
	    private Pane loginPage;

	@FXML
	private TextField username;

	@FXML
	private PasswordField password;

	@FXML
	private Button submit;

	private LoginService login;

	public void initialize() {
		try {
			Connection con = DriverManager.getConnection("jdbc:sqlite:MovieReviewApp.db");
			login = new LoginService(con);

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
    private void handleClick(ActionEvent event) {
        System.out.println("Button clicked!");
        loginPage.setVisible(true);

    }

}
