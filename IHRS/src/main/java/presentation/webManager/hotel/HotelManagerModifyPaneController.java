package presentation.webManager.hotel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class HotelManagerModifyPaneController {

	
	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField hotelTextField;
	
	@FXML
	private TextField phoneTextField;
	
	@FXML
	private PasswordField passwordField;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	public HotelManagerModifyPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleConfirmButton() {
		
	}
	
	@FXML
	private void handleCancelButton() {
		dialogStage.close();
	}
	
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
}
