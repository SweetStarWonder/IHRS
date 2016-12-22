package presentation.hotelManager.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNormalPromotionDialogController {
	
	
	@FXML
	private Label typeLabel;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField discountTextFiel;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	private String type;
	
	public AddNormalPromotionDialogController() {
		
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
	
	
	public void setType(String type) {
		this.type = type;
		typeLabel.setText(type);
	}
	
	public void setStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}
	
}
