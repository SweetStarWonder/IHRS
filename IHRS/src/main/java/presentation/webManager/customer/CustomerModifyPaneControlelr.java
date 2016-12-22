package presentation.webManager.customer;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class CustomerModifyPaneControlelr {
	
	
	@FXML
	private TextField idTextField;
	
	@FXML
	private TextField nameTextField;
	
	@FXML
	private TextField phoneTextField;
	
	@FXML
	private Button confirmButton;
	
	@FXML
	private Button cancelButton;
	
	private Stage dialogStage;
	
	public CustomerModifyPaneControlelr() {
		
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
