package presentation.webSale.promotion;

import controller.WebSaleController;
import javafx.fxml.FXML;

public class TypeChoosePaneController {

	private WebSaleController mainApp;

	private WebPromotionListController upperController;

	public TypeChoosePaneController() {

	}

	@FXML
	private void initialize() {

	}

	@FXML
	private void handleBusinessDistrictClick() {
		mainApp.addNormalVipPromotionPane(upperController);
	}

	@FXML
	private void handleTimeClick() {
		mainApp.addTimePromotionPane(upperController);
	}

	public void setMainApp(WebSaleController mainApp) {
		this.mainApp = mainApp;
	}

	public void setUpperController(WebPromotionListController upperController) {
		this.upperController = upperController;
	}
}
