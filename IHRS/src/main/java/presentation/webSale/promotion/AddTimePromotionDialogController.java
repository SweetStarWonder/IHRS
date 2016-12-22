package presentation.webSale.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddTimePromotionDialogController {

	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField discountTextFiel;
	
	@FXML
	private DatePicker beginTimeDatePicker;
	
	@FXML
	private DatePicker endTimeDatePicker;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	
	public AddTimePromotionDialogController() {
		
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
