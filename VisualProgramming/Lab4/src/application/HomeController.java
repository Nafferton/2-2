package application;

import java.io.IOException;
import javafx.event.ActionEvent;

public class HomeController {

	public void handleLogout(ActionEvent logoutEvent) throws IOException {
		SceneManager.switchScene(logoutEvent, "LoginScene.fxml", "Login");
	}
}
