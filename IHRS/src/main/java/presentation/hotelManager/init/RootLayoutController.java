package presentation.hotelManager.init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;
import presentation.hotelManager.TestHotelManager;

public class RootLayoutController {

	
	@FXML
	private MenuButton hotelNameLabel;
	
	@FXML
	private Button backButton;
	
	@FXML
	private MenuItem modifyPasswordMenuItem;
	
	@FXML
	private MenuItem signoutMenuItem;
	
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
	
	@FXML
	private void handleModifyPasswordMenuItem() {
		
	}
	
	@FXML
	private void handleSignoutMenuItem() {
		
	}
	
	public void setMainApp(TestHotelManager mainApp) {
		this.mainApp = mainApp;
	}
}
