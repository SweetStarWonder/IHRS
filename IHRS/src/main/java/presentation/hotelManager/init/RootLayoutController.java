package presentation.hotelManager.init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.hotelManager.TestHotelManager;

public class RootLayoutController {

	
	@FXML
	private Label hotelNameLabel;
	
	@FXML
	private Button backButton;
	
	private TestHotelManager mainApp;
	
	public RootLayoutController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleBackButton() {
		mainApp.backView();
	}
	
	public void setMainApp(TestHotelManager mainApp) {
		this.mainApp = mainApp;
	}
}
