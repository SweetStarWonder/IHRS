package presentation.webManager.hotel;

import org.controlsfx.control.Rating;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

public class AddHotelPaneController {

	
	@FXML
	private TextField hotelNameTextField;
	
	@FXML
	private TextField hotelIdTextField;
	
	@FXML
	private TextField addressTextField;
	
	@FXML
	private TextField businessDistrictTextField;
	
	@FXML
	private TextArea introductionTextField;
	
	@FXML
	private TextField facilityTextField;
	
	@FXML
	private AnchorPane starAnchorPane;
	
	private Rating rating;
	
	@FXML
	private TextField userNameTextField;
	
	@FXML
	private TextField userIdTextField;
	
	@FXML
	private TextField phoneTextField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Button confirmButton;
	
	public AddHotelPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		rating = new Rating(5, 0);
		starAnchorPane.getChildren().add(rating);
	}
	
	@FXML
	private void handleConfirmButton() {
		
	}
	
	
}
