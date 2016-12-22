package presentation.webSale.promotion;

import javafx.fxml.FXML;
import presentation.webSale.TestWebSale;

public class TypeChoosePaneController {
	
	
	private TestWebSale mainApp;
	
	public TypeChoosePaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleBusinessDistrictClick() {
		mainApp.addNormalVipPromotionPane();
	}
	
	@FXML
	private void handleTimeClick() {
		mainApp.addTimePromotionPane();
	}
	
	public void setMainApp(TestWebSale mainApp) {
		this.mainApp = mainApp;
	}
}
