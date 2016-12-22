package presentation.webManager.webSale;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class WebSaleInformationPaneController {

	
	@FXML
	private Label idLabel;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label phoneLabel;
	
	@FXML
	private Label passwordLabel;
	
	@FXML
	private Button modifyButton;
	
	private WebManagerController mainApp;
	
	public WebSaleInformationPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleModifyButton() {
		mainApp.modifyWebSaleDialog();
	}
	
	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}
}
