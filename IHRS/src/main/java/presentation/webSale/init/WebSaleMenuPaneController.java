package presentation.webSale.init;

import controller.WebSaleController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class WebSaleMenuPaneController {

	@FXML
	private Button promotionButton;

	@FXML
	private Button listButton;

	@FXML
	private Button rechargeButton;

	private WebSaleController mainApp;

	public WebSaleMenuPaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handlePromotionButton() {
		mainApp.showPromotion();
	}

	@FXML
	private void handleListButton() {
		mainApp.showList();
	}

	@FXML
	private void handleRechargeButton() {
		mainApp.showRechargePane();
	}

	public void setMainApp(WebSaleController mainApp) {
		this.mainApp = mainApp;
	}
}
