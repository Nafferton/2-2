package application;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TextField;

public class MenuController {
	@FXML
		private TextField ProductNameField;
	@FXML
		private TextField PriceField;
	@FXML
		private Spinner<Integer> QuantitySpinner;
	@FXML
		private ComboBox<String> CategoryComboBox;
	@FXML
		private TextField errorMessageField;
	
	public void handleViewInventory(ActionEvent viewInventoryEvent) {
		SceneSwitcher.switchScene(viewInventoryEvent, "tableScene.fxml", "Inventory");
	}
	
	@FXML
	public void initialize() {

		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100, 1);
		QuantitySpinner.setValueFactory(valueFactory);
		

		CategoryComboBox.getItems().addAll("Chemicals", "Glassware", "Electronics", "Heating");
		

		errorMessageField.setText("");
	}

	@FXML
	public void addProduct(ActionEvent event) {
		String name = ProductNameField.getText();
		String category = CategoryComboBox.getValue();
		String priceText = PriceField.getText();
		

		if (name == null || name.trim().isEmpty() || 
		    category == null || 
		    priceText == null || priceText.trim().isEmpty() || priceText.equals("$")) {
			
			errorMessageField.setText("There cannot be any empty fields");
			return;
		}
		
		try {

			double price = Double.parseDouble(priceText.replace("$", ""));
			int quantity = QuantitySpinner.getValue();
			

			Product newProduct = new Product(name, price, quantity, category);
			Product.inventoryData.add(newProduct);
			

			errorMessageField.setText("Product added successfully!");
			errorMessageField.setStyle("-fx-text-fill: green;");
			ProductNameField.clear();
			PriceField.setText("$");
			
		} catch (NumberFormatException e) {

			errorMessageField.setText("Price must be a valid number!");
			errorMessageField.setStyle("-fx-text-fill: red;");
		}
	}
}
