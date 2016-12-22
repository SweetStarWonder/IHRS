package presentation.hotelManager.promotion;

import javafx.fxml.FXML;
import presentation.hotelManager.TestHotelManager;

public class TypeChoosePaneController {
	
	
	private TestHotelManager mainApp;
	
	public TypeChoosePaneController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleBirthdayClick() {
		mainApp.addNormalPromotionPane("生日特惠折扣");
	}
	
	@FXML
	private void handleThreeClick() {
		mainApp.addNormalPromotionPane("三间及以上折扣");
	}
	
	@FXML
	private void handleEnterpriseClick() {
		mainApp.addNormalPromotionPane("合作企业客户折扣");
	}
	
	@FXML
	private void handleTimeClick() {
		mainApp.addTimePromotionPane();
	}
	
	public void setMainApp(TestHotelManager mainApp) {
		this.mainApp = mainApp;
	}
}
