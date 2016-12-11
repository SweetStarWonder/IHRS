package presentation.customer.information;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import presentation.customer.TestCustomer;

public class PersonalHotelCellController {
	
	
	
	@FXML
	private Hyperlink showHotelHyperLink;
	
	@FXML
	private Label listStatusLabel;
	
	@FXML
	private Label starLabel;
	
	@FXML
	private Label priceLabel;
	
	@FXML
	private Label rankLabel;
	
	@FXML
	private Button orderButton;
	
	private TestCustomer mainApp;
	
	public PersonalHotelCellController() {
		
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
