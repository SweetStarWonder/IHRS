package presentation.webSale.list;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.stage.Stage;

public class RevokeSelectPaneController {

	
	@FXML
	private ToggleButton halfToggleButton;
	
	@FXML
	private ToggleButton allToggleButton;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	public RevokeSelectPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleHalfToggleButton() {
		
	}
	
	@FXML
	private void handleAllToggleButton() {
		
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
