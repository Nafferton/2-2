package application;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class RegistrationController {
	@FXML
	private TextField UserField;
	@FXML
	private TextField PasswordField;
	@FXML
	private TextField ConfirmField;
	
	public void handleRegister(ActionEvent registerEvent) throws IOException {
		
		String username = UserField.getText();
		String password = PasswordField.getText();
		String confirmPassword = ConfirmField.getText();
		
		if(!password.equals(confirmPassword)) {
			System.out.println("Passwords do not match");
			return;
		}
		User user = new User();
		if(username.isEmpty() || password.isEmpty()) {
			System.out.println("Username and password cannot be empty");
			return;
		}
		if(user.validateUser(username, confirmPassword)) {
			System.out.println("Username already exists");
			return;
		}
		user.addUser(username, password);
		
		SceneManager.switchScene(registerEvent, "LoginScene.fxml", "Login");
	}
}
