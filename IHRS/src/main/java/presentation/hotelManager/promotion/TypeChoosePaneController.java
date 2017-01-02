package presentation.hotelManager.promotion;

import controller.HotelManagerController;
import javafx.fxml.FXML;

public class TypeChoosePaneController {

	private HotelManagerController mainApp;

	private HotelPromotionListController upperController;

	public TypeChoosePaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleBirthdayClick() {
		mainApp.addNormalPromotionPane(upperController, "BIRTHDAY");
	}

	@FXML
	private void handleThreeClick() {
		mainApp.addNormalPromotionPane(upperController, "THREE");
	}

	@FXML
	private void handleEnterpriseClick() {
		mainApp.addNormalPromotionPane(upperController, "ENTERPRISE");
	}

	@FXML
	private void handleTimeClick() {
		mainApp.addTimePromotionPane(upperController);
	}

	public void setMainApp(HotelManagerController mainApp) {
		this.mainApp = mainApp;
	}

	public void setUpperController(HotelPromotionListController upperController) {
		this.upperController = upperController;
	}
}
