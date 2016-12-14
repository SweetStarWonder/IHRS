package presentation.hotelManager.hotel;

import org.controlsfx.control.Rating;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class HotelInformationModifyController {
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private TextField adressTextField;
	
	@FXML
	private TextField businessDistrictTextField;
	
	@FXML
	private TextArea introductionTextArea;
	
	@FXML
	private TextField facilityTextField;
	
	@FXML
	private AnchorPane starAnchorPane;
	
	@FXML
	private Button confirmButton;
	
	public HotelInformationModifyController() {
		
	}
	
	@FXML
	private void initialize() {
		Rating rating = new Rating(5, 0);
		starAnchorPane.getChildren().add(rating);
	}
	
	@FXML
	private void handleConfirmButton() {
		
	}
}
