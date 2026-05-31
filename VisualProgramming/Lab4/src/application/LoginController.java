package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;


public class LoginController {
	@FXML
	private TextField usernameField;
	@FXML
	private TextField passwordField;

	public void handleLogin(ActionEvent loginEvent) throws IOException {
		String username = usernameField.getText();
		String password = passwordField.getText();
		User user = new User();

		if(user.validateUser(username, password)) {
			SceneManager.switchScene(loginEvent, "HomeScene.fxml", "Home");
		} else {
			System.out.println("Invalid credentials");
			return;
		}

	}
	public void goRegister(ActionEvent registerEvent) throws IOException {
		SceneManager.switchScene(registerEvent, "RegistrationScene.fxml", "Register");
	}
}
