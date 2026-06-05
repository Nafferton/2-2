package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Button;

public class TableController {
	
	@FXML private TableView<Product> inventoryTable;
	@FXML private TableColumn<Product, String> nameColumn;
	@FXML private TableColumn<Product, String> categoryColumn;
	@FXML private TableColumn<Product, Integer> quantityColumn;
	@FXML private TableColumn<Product, Double> priceColumn;
	@FXML private TableColumn<Product, Button> actionColumn;
	
	@FXML
	public void initialize() {

		nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
		categoryColumn.setCellValueFactory(new PropertyValueFactory<>("category"));
		quantityColumn.setCellValueFactory(new PropertyValueFactory<>("quantity"));
		priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
		actionColumn.setCellValueFactory(new PropertyValueFactory<>("actionButton"));
		
		inventoryTable.setItems(Product.inventoryData);
	}

	public void handleBack(ActionEvent backEvent) {
		SceneSwitcher.switchScene(backEvent, "menuScene.fxml", "Menu");
	}
}
