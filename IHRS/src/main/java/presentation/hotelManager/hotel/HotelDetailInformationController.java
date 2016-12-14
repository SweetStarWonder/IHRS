package presentation.hotelManager.hotel;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import presentation.hotelManager.TestHotelManager;

public class HotelDetailInformationController {

	
	@FXML
	private Label nameLabel;
	
	@FXML
	private Label addressLabel;
	
	@FXML
	private Label businessDistrictLabel;
	
	@FXML
	private Label introductionLabel;
	
	@FXML
	private Label facilityLabel;
	
	@FXML
	private Label starLabel;
	
	@FXML 
	private Button modifyButton;
	
	private TestHotelManager mainApp;
	
	public HotelDetailInformationController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleModifyButton() {
		mainApp.modifyHotelInformation();
	}
	
	public void setMainApp(TestHotelManager mainApp) {
		this.mainApp = mainApp;
	}
}
