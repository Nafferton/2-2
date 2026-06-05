package application;

import javafx.scene.control.Button;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Product {
	private String name;
	private double price;
	private int quantity;
	private String category;
	private Button actionButton; 

	public static ObservableList<Product> inventoryData = FXCollections.observableArrayList();

	public Product(String name, double price, int quantity, String category) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.category = category;
		 
		this.actionButton = new Button("Delete");
		this.actionButton.setStyle("-fx-background-color: red; -fx-text-fill: white;");
		
		this.actionButton.setOnAction(event -> {
			inventoryData.remove(this);
		});
	}

	public String getName() { return name; }
	public double getPrice() { return price; }
	public int getQuantity() { return quantity; }
	public String getCategory() { return category; }
	public Button getActionButton() { return actionButton; }
}
