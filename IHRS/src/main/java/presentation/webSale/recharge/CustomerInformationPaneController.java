package presentation.webSale.recharge;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.webSale.TestWebSale;

public class CustomerInformationPaneController {
	
	
	@FXML
	private Label userNameLabel;
	
	@FXML
	private Label userIdLabel;
	
	@FXML
	private Label phoneLabel;
	
	@FXML
	private Button rechargeButton;
	
	private TestWebSale mainApp;
	
	public CustomerInformationPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleRechargeButton() {
		mainApp.inputMoneyDialog();
	}
	
	public void setMainApp(TestWebSale mainApp) {
		this.mainApp = mainApp;
	}
}
