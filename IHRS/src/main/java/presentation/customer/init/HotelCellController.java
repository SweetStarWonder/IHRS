package presentation.customer.init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import presentation.customer.TestCustomer;

public class HotelCellController {
	
	
	@FXML
	private Hyperlink hotelNameHyperLink;
	
	@FXML
	private Label reservedLabel;
	
	@FXML
	private Label starLabel;
	
	@FXML 
	private Label priceLabel;
	
	@FXML
	private Label rankLabel;
	
	@FXML
	private Button orderButton;
	
	private TestCustomer mainApp;
	
	public HotelCellController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void showHotelDetailInformation() {
		mainApp.showHotelDetailInformation();
	}
	
	@FXML
	private void handleOrderButton() {
		mainApp.showGenerateList();
	}
	
	public void setMainApp(TestCustomer mainApp) {
		this.mainApp = mainApp;
	}
}
