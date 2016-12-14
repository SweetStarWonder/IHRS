package presentation.hotelManager.init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.hotelManager.TestHotelManager;

public class MenuPaneController {

	
	@FXML
	private Button informationButton;
	
	@FXML
	private Button promotionButton;
	
	@FXML
	private Button roomButton;
	
	@FXML
	private Button listButton;
	
	private TestHotelManager mainApp;
	
	public MenuPaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleInformationButton() {
		mainApp.showHotelInformation();
	}
	
	@FXML
	private void handlePromotionButton() {
		
	}
	
	@FXML
	private void handleRoomButton() {
		
	}
	
	@FXML
	private void handleListButton() {
		
	}
	
	public void setMainApp(TestHotelManager mainApp) {
		this.mainApp = mainApp;
	}
}
