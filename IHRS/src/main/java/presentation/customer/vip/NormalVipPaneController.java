package presentation.customer.vip;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

public class NormalVipPaneController {

	@FXML
	private DatePicker birthdayDatePicker;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage normalVipStage;
	
	public NormalVipPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	public void setNormalVipStage(Stage normalVipStage) {
		this.normalVipStage = normalVipStage;
	}
	
	@FXML
	private void handleConfirm() {
		
	}
	
	@FXML
	private void handleCancel() {
		normalVipStage.close();
	}
}
