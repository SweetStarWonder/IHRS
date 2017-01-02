package presentation.hotelManager.init;

import controller.HotelManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuButton;
import javafx.scene.control.MenuItem;

public class RootLayoutController {

	@FXML
	private MenuButton hotelNameLabel;

	@FXML
	private Button backButton;

	@FXML
	private MenuItem modifyPasswordMenuItem;

	@FXML
	private MenuItem signoutMenuItem;

	private HotelManagerController mainApp;

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
		mainApp.signout();
	}

	public void setMainApp(HotelManagerController mainApp) {
		this.mainApp = mainApp;
		hotelNameLabel.setText(mainApp.getSelf().getUserName());
	}
}
