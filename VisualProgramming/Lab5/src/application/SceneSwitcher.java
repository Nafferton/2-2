package application;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.ActionEvent;

public class SceneSwitcher {
	public static void switchScene(ActionEvent event, String fxmlFile, String title) {
		try {
			Parent root = FXMLLoader.load(SceneSwitcher.class.getResource(fxmlFile));
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle(title);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}

