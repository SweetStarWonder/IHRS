package presentation.webSale.promotion;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class AddNormalVipPromotionDialogController {
	
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField discountTextFiel;
	
	@FXML
	private ComboBox<String> businessDistrictComboBox;
	
	@FXML
	private ComboBox<Integer> rankComboBox;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	public AddNormalVipPromotionDialogController() {
		
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
