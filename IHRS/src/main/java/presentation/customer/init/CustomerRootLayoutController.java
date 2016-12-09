package presentation.customer.init;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import presentation.customer.TestCustomer;

public class CustomerRootLayoutController {
	
	
	@FXML
	private Button backButton;
	
	@FXML
	private MenuItem personalInformationItem;

	@FXML
	private MenuItem creditRecordItem;

	@FXML
	private MenuItem registerNormalVipItem;

	@FXML
	private MenuItem registerEnterpriseVipItem;

	@FXML
	private MenuItem signOutItem;

	@FXML
	private MenuItem personalListItem;

	@FXML
	private MenuItem personalHotelItem;
	
	@FXML
	private TestCustomer testCustomer;
	
	public CustomerRootLayoutController() {
		
	}
	
	@FXML
	private void initialize() {
		
	}
	
	@FXML
	private void handleBackButton() {
		testCustomer.backView();
	}
	
	@FXML
	private void showPersonalLists() {
		testCustomer.showPersonalLists();
	}
	
	@FXML
	private void showPersonalInformation() {
		testCustomer.showPersonalInformation();
	}
	
	@FXML 
	private void showCreditRecord() {
		testCustomer.showCreditRecord();
	}
	
	@FXML
	private void registerNormalVip() {
		testCustomer.registerNormalVip();
	}
	
	@FXML 
	private void registerEnterpriseVip() {
		testCustomer.registerEnterpriseVip();
	}
	
	@FXML
	private void showPersonalHotels() {
		testCustomer.showPersonalHotels();
	}
	
	public void setMainApp(TestCustomer testCustomer) {
		this.testCustomer = testCustomer;
	}
}
