package presentation.customer.hotel;

import java.io.IOException;

import org.controlsfx.control.PopOver;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

public class HotelDetailInformationController {
	
	@FXML
	private Label adressLabel;
	
	@FXML
	private Label introductionLabel;
	
	@FXML
	private Label facilityLabel;
	
	@FXML
	private Label singleNumLabel;
	
	@FXML
	private Label singlePriceLabel;
	
	@FXML
	private Label doubleNumLabel;
	
	@FXML
	private Label doublePriceLabel;
	
	@FXML
	private Label tripleNumLabel;
	
	@FXML
	private Label triplePriceLabel;
	
	@FXML
	private Button viewEvaluateButton;
	
	@FXML 
	private Button purchaseButton;
	
	public HotelDetailInformationController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleViewEvaluateButton () {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(HotelDetailInformationController.class.getResource("HotelEvaluateListView.fxml"));
		AnchorPane anchorPane = null;
		try {
			anchorPane = (AnchorPane) loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		PopOver popOver = new PopOver(anchorPane);
		popOver.show(viewEvaluateButton);
	}
	
	@FXML
	private void handlePurchaseButton() {
		
	}
}
