package presentation.webManager.customer;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class CustomerInformationPaneController {

	
	@FXML
	private Label idLabel;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label phoneLabel;
	
	@FXML
	private Button modifyButton;
	
	private WebManagerController mainApp;
	
	public CustomerInformationPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleModifyButton() {
		mainApp.modifyCustomerDialog();
	}
	
	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}
}
