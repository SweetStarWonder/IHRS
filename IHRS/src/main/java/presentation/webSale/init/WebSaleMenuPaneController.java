package presentation.webSale.init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import presentation.webSale.TestWebSale;

public class WebSaleMenuPaneController {
	
	
	@FXML
	private Button promotionButton;
	
	@FXML
	private Button listButton;
	
	@FXML
	private Button rechargeButton;
	
	private TestWebSale mainApp;
	
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
	
	public void setMainApp(TestWebSale mainApp) {
		this.mainApp = mainApp;
	}
}
