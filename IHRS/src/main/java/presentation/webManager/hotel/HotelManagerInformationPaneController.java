package presentation.webManager.hotel;

import controller.WebManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HotelManagerInformationPaneController {

	@FXML
	private Label idLabel;
	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label hotelLabel;
	
	@FXML
	private Label phoneLabel;
	
	@FXML
	private Label passwordLabel;
	
	@FXML
	private Button modifyButton;
	
	private WebManagerController mainApp;
	
	public HotelManagerInformationPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleModifyButton() {
		mainApp.modifyHotelManagerDialog();
	}
	
	public void setMainApp(WebManagerController mainApp) {
		this.mainApp = mainApp;
	}
}
