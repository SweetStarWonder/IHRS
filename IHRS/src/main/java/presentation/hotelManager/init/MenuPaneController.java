package presentation.hotelManager.init;

import controller.HotelManagerController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MenuPaneController {

	@FXML
	private Button informationButton;

	@FXML
	private Button promotionButton;

	@FXML
	private Button roomButton;

	@FXML
	private Button listButton;

	private HotelManagerController mainApp;

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
		mainApp.showHotelPromotion();
	}

	@FXML
	private void handleRoomButton() {
		mainApp.showRoomInformation();
	}

	@FXML
	private void handleListButton() {
		mainApp.showLists();
	}

	public void setMainApp(HotelManagerController mainApp) {
		this.mainApp = mainApp;
	}
}
