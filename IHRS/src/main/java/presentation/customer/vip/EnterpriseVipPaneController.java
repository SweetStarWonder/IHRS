package presentation.customer.vip;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class EnterpriseVipPaneController {
	
	
	
	@FXML
	private TextArea enterpriseNameTextField;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage normalVipStage;
	
	public EnterpriseVipPaneController() {
		
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
